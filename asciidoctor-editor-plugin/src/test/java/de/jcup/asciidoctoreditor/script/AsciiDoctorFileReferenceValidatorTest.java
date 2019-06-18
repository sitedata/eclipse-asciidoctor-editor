package de.jcup.asciidoctoreditor.script;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import de.jcup.asciidoctoreditor.TestResourcesLoader;

public class AsciiDoctorFileReferenceValidatorTest {

    private AsciiDoctorFileReferenceValidator validatorToTest;

    @Before
    public void before() {
        validatorToTest = new AsciiDoctorFileReferenceValidator();
    }
    
    @Test
    public void valid_include() {
        /* prepare */
        File editorFile = TestResourcesLoader.assertTestFile("codeassist/include/test1/editorfile1.adoc");
        Collection<AsciiDoctorMarker> errors = new ArrayList<>();
        
        /* execute */
        validatorToTest.validate(editorFile, Collections.singleton(new AsciiDoctorFileReference("include::otherfile1.adoc[]", 1, 20, 20)),errors);
        
        /* test */
        assertTrue(errors.isEmpty());
    }
    
    @Test
    public void non_existing_include() {
        /* prepare */
        File editorFile = TestResourcesLoader.assertTestFile("codeassist/include/test1/editorfile1.adoc");
        Collection<AsciiDoctorMarker> errors = new ArrayList<>();
        
        /* execute */
        validatorToTest.validate(editorFile, Collections.singleton(new AsciiDoctorFileReference("include::unkknown.adoc[]", 1, 20, 20)),errors);
        
        /* test */
        assertEquals(1,errors.size());
    }
    
    @Test
    public void non_existing_include_only_start_tag() {
        /* prepare */
        File editorFile = TestResourcesLoader.assertTestFile("codeassist/include/test1/editorfile1.adoc");
        Collection<AsciiDoctorMarker> errors = new ArrayList<>();
        
        /* execute */
        validatorToTest.validate(editorFile, Collections.singleton(new AsciiDoctorFileReference("include::", 1, 20, 20)),errors);
        
        /* test */
        assertEquals(1,errors.size());
    }

}