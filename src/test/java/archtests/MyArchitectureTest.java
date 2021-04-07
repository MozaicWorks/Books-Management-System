package archtests;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import org.junit.jupiter.api.Test;

public class MyArchitectureTest {
	@Test
	public void daoClassNamesShouldEndInDao() {
		JavaClasses importedClasses = new ClassFileImporter().importPackages("com.book.dao");

		ArchRule rule = classes().should().haveNameMatching(".*Dao(\\$.)*");

		rule.check(importedClasses);
	}

	@Test
	public void daoClassesShouldHaveOnlyFinalFields() {
		JavaClasses importedClasses = new ClassFileImporter().importPackages("com.book.dao");

		ArchRule rule = classes().should().haveOnlyFinalFields();

		rule.check(importedClasses);
	}
}