/*
 * Copyright 2019 Albert Tregnaghi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 */
package de.jcup.asciidoctoreditor.script;

/**
 * Implementation informa about details for text selection in asciidoctor documents
 * @author albert
 *
 */
public interface AsciidoctorTextSelectable {

    /**
     * @return start position
     */
    public int getSelectionStart();
    
    /**
     * 
     * @return length of selection (starting from position)
     */
    public int getSelectionLength();

    /**
     * @return real offset (not for selection, but for element itself inside document) - can differ to selection start but must not
     */
    public int getPosition();


}
