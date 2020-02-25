package db.migration;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.flywaydb.core.internal.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import nc.dva.examples.geo.codes.postaux.CodePostalCommune;

public class V1_0_1__InjectCodesPostaux extends BaseJavaMigration {

	private static final Logger LOGGER = LoggerFactory.getLogger(V1_0_1__InjectCodesPostaux.class);

	final String query = "INSERT INTO code_postal(code_postal, code_insee, nom_commune, libelle_acheminement) VALUES ( ?, ?, ?, ?)";

	@Override
	public void migrate(Context context) throws Exception {
		JdbcTemplate jdbcTemplate;
		jdbcTemplate = new JdbcTemplate(
				new SingleConnectionDataSource(context.getConnection(), true).getConnection());
		Gson gson = new Gson();
		InputStreamReader isr = new InputStreamReader(
				getClass().getClassLoader().getResourceAsStream("codes-postaux.json"), "ISO-8859-1");
		JsonReader reader = new JsonReader(isr);
		reader.beginArray();
		while (reader.hasNext()) {
			final CodePostalCommune cpc = gson.fromJson(reader, CodePostalCommune.class);
			cpc.setLibelleAcheminement(StringUtils.replace(cpc.getLibelleAcheminement(), "'", "''"));
			cpc.setNomCommune(StringUtils.replace(cpc.getNomCommune(), "'", "''"));
			LOGGER.info(cpc.toString());
			jdbcTemplate.execute(query, (PreparedStatementCallback<Boolean>) ps -> {

				ps.setString(1, cpc.getCodePostal());
				ps.setString(2, cpc.getCodeCommune());
				ps.setString(3, cpc.getNomCommune());
				ps.setString(4, cpc.getLibelleAcheminement());

				return ps.execute();

			});
		}
		reader.endArray();
		reader.close();
	}

}
