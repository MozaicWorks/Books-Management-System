package archtests;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MyArchitectureTest {
	@Test
	public void daoClassNamesShouldEndInDao() {
		JavaClasses importedClasses = new ClassFileImporter().importPackages("com.book.dao");

		ArchRule rule = classes().should().haveNameMatching(".*Dao(\\$.)*");

		rule.check(importedClasses);
	}

	@Test
	@Disabled
	public void daoClassesShouldHaveOnlyFinalFields() {
		JavaClasses importedClasses = new ClassFileImporter().importPackages("com.book.dao");

		ArchRule rule = classes().should().haveOnlyFinalFields();

		rule.check(importedClasses);
	}

	@Test
	public void DomainClassesShouldOnlyHaveGettersAndSettersAndToString() {
		JavaClasses importedClasses = new ClassFileImporter().importPackages("com.book.domain");

		ArchRule rule = ArchRuleDefinition.methods()
			.that().arePublic()
			.should().haveNameStartingWith("get")
			.orShould().haveNameStartingWith("set")
			.orShould().haveName("toString");

		rule.check(importedClasses);
	}
}
