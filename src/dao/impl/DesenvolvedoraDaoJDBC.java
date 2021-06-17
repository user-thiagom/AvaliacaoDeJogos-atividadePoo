package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DesenvolvedoraDao;
import db.DB;
import db.DbException;
import entities.Desenvolvedora;

public class DesenvolvedoraDaoJDBC implements DesenvolvedoraDao {
	private Connection conn;

	public DesenvolvedoraDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Desenvolvedora obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"INSERT INTO desenvolvedora " +
				    "(nome, nota) " +
					"VALUES " +
				    "(?,?)"
				);
			st.setString(1, obj.getNome());
			st.setDouble(2, obj.getNota());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
						"DELETE FROM desenvolvedora " +
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
	public Desenvolvedora findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
						"SELECT * FROM desenvolvedora WHERE Id = ?"
					);

			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				Desenvolvedora obj = new Desenvolvedora();
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				obj.setNota(rs.getDouble("nota"));
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

	@Override
	public List<Desenvolvedora> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM desenvolvedora ORDER BY nome");
			rs = st.executeQuery();

			List<Desenvolvedora> list = new ArrayList<>();

			while (rs.next()) {
				Desenvolvedora obj = new Desenvolvedora();
				obj.setId(rs.getInt("Id"));
				obj.setNome(rs.getString("nome"));
				obj.setNota(rs.getDouble("nota"));
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
