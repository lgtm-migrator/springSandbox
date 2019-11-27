package db.migration;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.flywaydb.core.internal.util.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import nc.dva.examples.geo.codes.postaux.CodePostalCommune;

public class V1_0_1__InjectCodesPostaux extends BaseJavaMigration {

	final String query = "INSERT INTO code_postal(code_postal, code_insee, nom_commune, libelle_acheminement) VALUES ( ?, ?, ?, ?)";

	@Override
	public void migrate(Context context) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(
				(Connection) new SingleConnectionDataSource(context.getConnection(), true));
		Gson gson = new Gson();
		InputStreamReader isr = new InputStreamReader(
				getClass().getClassLoader().getResourceAsStream("codes-postaux.json"), "UTF-8");
		JsonReader reader = new JsonReader(isr);
		reader.beginArray();
		while (reader.hasNext()) {
			final CodePostalCommune cpc = gson.fromJson(reader, CodePostalCommune.class);
			cpc.setLibelleAcheminement(StringUtils.replace(cpc.getLibelleAcheminement(), "'", "''"));
			cpc.setNomCommune(StringUtils.replace(cpc.getNomCommune(), "'", "''"));
			jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

					ps.setString(1, cpc.getCodePostal());
					ps.setString(2, cpc.getCodeCommune());
					ps.setString(3, cpc.getNomCommune());
					ps.setString(4, cpc.getLibelleAcheminement());

					return ps.execute();

				}
			});
		}
		reader.endArray();
		reader.close();
	}

}
