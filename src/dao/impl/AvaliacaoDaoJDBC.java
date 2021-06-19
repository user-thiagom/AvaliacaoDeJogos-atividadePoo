package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AvaliacaoDao;
import db.DB;
import db.DbException;
import entities.Avaliacao;
import entities.AvaliacaoEspecializada;
import entities.AvaliacaoJogador;
import entities.Review;
import entities.TempoParaTerminar;

public class AvaliacaoDaoJDBC implements AvaliacaoDao {
	private Connection conn;
	
	public AvaliacaoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Avaliacao obj, Integer idJogo) {
		PreparedStatement st = null;
		
		try {
			if (obj.getAvaliacaoEspecializada()) {
				AvaliacaoEspecializada objEsp = (AvaliacaoEspecializada) obj;
				st = conn.prepareStatement(
						"INSERT INTO avalicao " +
					    "(isAvaliacaoEsp, titulo, texto, horas, todasAsConquistas, notaNarrativa, notaDirecaoJogo, notaDirecaoDeArte, notaMusicaDoJogo, notaDirecaoDeAudio, fk_Jogo_id) " +
						"VALUES " +
					    "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
					);
				st.setDouble(1, objEsp.getNota());
				st.setBoolean(2, objEsp.getAvaliacaoEspecializada());
				st.setString(3, objEsp.getReview().getTitulo());
				st.setString(4, objEsp.getReview().getTexto());
				st.setInt(5, objEsp.getTempoParaTerminar().getHoras());
				st.setBoolean(6, objEsp.getTempoParaTerminar().getTodasConquistas());
				st.setDouble(7, objEsp.getNotaNarrativa());
				st.setDouble(8, objEsp.getNotaDirecaoDoJogo());
				st.setDouble(9, objEsp.getNotaDirecaoDeArte());
				st.setDouble(10, objEsp.getNotaMusicaDoJogo());
				st.setDouble(11, objEsp.getNotaDirecaoDeAudio());
				st.setInt(12, idJogo);
			} else {
				AvaliacaoJogador objJog = (AvaliacaoJogador) obj;
				st = conn.prepareStatement(
						"INSERT INTO avalicao " +
					    "(nota, isAvaliacaoEsp, titulo, texto, horas, todasAsConquistas, recomenda, fk_Jogo_id) " +
						"VALUES " +
					    "(?, ?, ?, ?, ?, ?, ?, ?)"
					);
				st.setDouble(1, objJog.getNota());
				st.setBoolean(2, objJog.getAvaliacaoEspecializada());
				st.setString(3, objJog.getReview().getTitulo());
				st.setString(4, objJog.getReview().getTexto());
				st.setInt(5, objJog.getTempoParaTerminar().getHoras());
				st.setBoolean(6, objJog.getTempoParaTerminar().getTodasConquistas());
				st.setBoolean(7, objJog.getRecomenda());
				st.setInt(8, idJogo);
			}
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
						"DELETE FROM avalicao " +
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
	public Avaliacao findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM avalicao where id = ?"
					);

			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				Review review = instanciarReview(rs);
				TempoParaTerminar tpTerminar = instanciarTpTerminar(rs);
				Avaliacao avaliacao = instanciarAvaliacao(tpTerminar, review, rs);
				return avaliacao;
			}

			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Avaliacao> findAllByGameId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM avalicao where fk_Jogo_id = ? order by titulo"
					);
			st.setInt(1, id);
			rs = st.executeQuery();

			List<Avaliacao> avaliacoes = new ArrayList<>();
			while (rs.next()) {
				TempoParaTerminar tp = instanciarTpTerminar(rs);
				Review rv = instanciarReview(rs);
				avaliacoes.add(instanciarAvaliacao(tp, rv, rs));
			}
			return avaliacoes;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	private Review instanciarReview(ResultSet rs) throws SQLException {
		Review review = new Review();
		review.setId(rs.getInt("id"));
		review.setTexto(rs.getString("texto"));
		review.setTitulo(rs.getString("titulo"));
		return review;
	}
	
	private TempoParaTerminar instanciarTpTerminar(ResultSet rs) throws SQLException {
		TempoParaTerminar tp = new TempoParaTerminar();
		tp.setHoras(rs.getInt("horas"));
		tp.setId(rs.getInt("id"));
		tp.setTodasConquistas(rs.getBoolean("todasAsConquistas"));
		return tp;
	}
	
	private Avaliacao instanciarAvaliacao(TempoParaTerminar tp, Review rv, ResultSet rs) throws SQLException {
		if (rs.getBoolean("isAvaliacaoEsp")) {
			AvaliacaoEspecializada av = new AvaliacaoEspecializada();
			av.setId(rs.getInt("id"));
			av.setNota(rs.getDouble("nota"));
			av.setAvaliacaoEspecializada(rs.getBoolean("isAvaliacaoEsp"));
			av.setReview(rv);
			av.setTempoParaTerminar(tp);
			av.setNotaDirecaoDeArte(rs.getDouble("notaDirecaoDeArte"));
			av.setNotaDirecaoDeAudio(rs.getDouble("notaDirecaoDeAudio"));
			av.setNotaDirecaoDoJogo(rs.getDouble("notaDirecaoJogo"));
			av.setNotaMusicaDoJogo(rs.getDouble("notaMusicaDoJogo"));
			av.setNotaNarrativa(rs.getDouble("notaNarrativa"));
			return av;
		} else {
			AvaliacaoJogador av = new AvaliacaoJogador();
			av.setId(rs.getInt("id"));
			av.setNota(rs.getDouble("nota"));
			av.setAvaliacaoEspecializada(rs.getBoolean("isAvaliacaoEsp"));
			av.setReview(rv);
			av.setTempoParaTerminar(tp);
			av.setRecomenda(rs.getBoolean("recomenda"));
			return av;
		}
	}
}
