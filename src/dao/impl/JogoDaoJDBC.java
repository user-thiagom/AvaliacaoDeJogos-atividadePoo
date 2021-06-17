package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.JogoDao;
import db.DB;
import db.DbException;
import entities.Desenvolvedora;
import entities.Jogo;
import entities.Plataforma;
import entities.enums.Genero;

public class JogoDaoJDBC implements JogoDao {
	private Connection conn;

	public JogoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Jogo obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(
						"INSERT INTO jogo " +
					    "(nome, notaCriticos, notaJogadores, DataDeLancamento, genero, fk_Desenvolvedora_id, fk_Plataforma_id_) " +
						"VALUES " +
					    "(?, ?, ?, ?, ?, ?, ?)"
					);

			st.setString(1, obj.getNome());
			st.setDouble(2, obj.getNotaDosCriticos());
			st.setDouble(3, obj.getNotaDosJogadores());
			st.setDate(4, new Date(obj.getDataDeLancamento().getTime()));
			st.setString(5, obj.getGenero().toString());
			st.setInt(6, obj.getDesenvolvedora().getId());
			st.setInt(7, obj.getPlataforma().getId());

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
						"DELETE FROM jogo " +
						"WHERE Id = ?"
					);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public Jogo findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM jogo where id = ?"
					);

			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				Plataforma plataforma = instanciarPlataforma(rs);
				Desenvolvedora desenvolvedora = instanciarDesenvolvedora(rs);
				Jogo obj = instanciarJogo(rs, plataforma, desenvolvedora);
				return obj;
			}

			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	private Jogo instanciarJogo(ResultSet rs, Plataforma plat, Desenvolvedora dev) throws SQLException {
		Jogo obj = new Jogo();
		obj.setId(rs.getInt("id"));
		obj.setNome(rs.getString("nome"));
		obj.setNotaDosCriticos(rs.getDouble("notaCriticos"));
		obj.setNotaDosJogadores(rs.getDouble("notaJogadores"));
		obj.setDataDeLancamento(rs.getDate("dataDeLancamento"));
		obj.setGenero(Genero.valueOf(rs.getString("genero")));
		obj.setDesenvolvedora(dev);
		obj.setPlataforma(plat);
		return obj;
	}

	private Desenvolvedora instanciarDesenvolvedora(ResultSet rs) throws SQLException {
		PreparedStatement ps = null;
		ResultSet resultado = null;
		
		try {
			ps = conn.prepareStatement("select * from desenvolvedora where id = ?");
			ps.setInt(1, rs.getInt("fk_Desenvolvedora_id"));
			resultado = ps.executeQuery();
			
			if (resultado.next()) {
				Desenvolvedora obj = new Desenvolvedora();
				obj.setId(resultado.getInt("id"));
				obj.setNome(resultado.getString("nome"));
				obj.setNota(resultado.getDouble("nota"));
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(resultado);
			DB.closeStatement(ps);
		}
	}
	
	private Plataforma instanciarPlataforma(ResultSet rs) throws SQLException {
		PreparedStatement ps = null;
		ResultSet resultado = null;
		
		try {
			ps = conn.prepareStatement("select * from plataforma where id_ = ?");
			ps.setInt(1, rs.getInt("fk_Plataforma_id_"));
			resultado = ps.executeQuery();
			
			if (resultado.next()) {
				Plataforma obj = new Plataforma();
				obj.setId(resultado.getInt("id_"));
				obj.setNome(resultado.getString("nome"));
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(resultado);
			DB.closeStatement(ps);
		}
		
		
	}

	@Override
	public List<Jogo> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM jogo order by nome"
					);
			rs = st.executeQuery();

			List<Jogo> jogos = new ArrayList<>();
			Map<Integer, Desenvolvedora> mapDev = new HashMap<>();
			Map<Integer, Plataforma> mapPlat = new HashMap<>();
			while (rs.next()) {
				Desenvolvedora dev = mapDev.get(rs.getInt("fk_Desenvolvedora_id"));
				if (dev == null) {
					dev = instanciarDesenvolvedora(rs);
					mapDev.put(rs.getInt("fk_Desenvolvedora_id"), dev);
				}
				Plataforma plat = mapPlat.get(rs.getInt("fk_Plataforma_id_"));
				if (plat == null) {
					plat = instanciarPlataforma(rs);
					mapPlat.put(rs.getInt("fk_Plataforma_id_"), plat);
				}
				jogos.add(instanciarJogo(rs, plat, dev));
			}
			return jogos;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}


}
