package db.migration;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import db.migration.utils.ClassAttributeSpy;
import nc.dva.examples.countries.PaysEtTerritoiresEtrangers;

public class V1_0_1__PaysEtTerritoiresEtrangers implements SpringJdbcMigration {

	@Override
	public void migrate(JdbcTemplate jdbcTemplate) {

		final String query = "INSERT INTO pays(cog, actual, capay, crpay, ani, libcog, libenr, ancnom, codeiso2, codeiso3, codenum3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

		ICsvBeanReader reader = null;

		try {

			reader = new CsvBeanReader(
					new InputStreamReader(getClass().getClassLoader().getResourceAsStream("pays2017.csv"),
							"ISO-8859-1"),
					CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);

			final String[] header = ClassAttributeSpy.getInstance().getAttributesList(PaysEtTerritoiresEtrangers.class);

			final CellProcessor[] processors = getProcessors();

			List<PaysEtTerritoiresEtrangers> list = new ArrayList<PaysEtTerritoiresEtrangers>();
			PaysEtTerritoiresEtrangers p;
			while ((p = reader.read(PaysEtTerritoiresEtrangers.class, header, processors)) != null) {
				list.add(p);
			}

			for (Object o : list) {
				final PaysEtTerritoiresEtrangers pc = (PaysEtTerritoiresEtrangers) o;

				jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

						ps.setString(1, StringUtils.trimToNull(pc.getCodePays()));
						ps.setString(2, StringUtils.trimToNull(pc.getCodeActualite()));
						ps.setString(3, StringUtils.trimToNull(pc.getCodeAncienPaysRattachement()));
						ps.setString(4, StringUtils.trimToNull(pc.getCodeActuelPaysRattachement()));
						ps.setString(5, StringUtils.trimToNull(pc.getAnneeIndependance()));
						ps.setString(6, StringUtils.trimToNull(pc.getLibelleCOG()));
						ps.setString(7, StringUtils.trimToNull(pc.getLibelleEnrichi()));
						ps.setString(8, StringUtils.trimToNull(pc.getAncienNom()));
						ps.setString(9, StringUtils.trimToNull(pc.getCodeIso2()));
						ps.setString(10, StringUtils.trimToNull(pc.getCodeIso3()));
						ps.setString(11, StringUtils.trimToNull(pc.getCodenum3()));

						return ps.execute();

					}
				});

			}

		} catch (IOException e) {

			System.out.println(e);

			if (e.getCause() != null) {
				System.out.println(e.getCause());
			}

		}

	}

	private static CellProcessor[] getProcessors() {

		final CellProcessor[] processors = new CellProcessor[] { new Optional(), new Optional(), new Optional(),
				new Optional(), new Optional(), new Optional(), new Optional(), new Optional(), new Optional(),
				new Optional(), new Optional()

		};

		return processors;
	}

}
