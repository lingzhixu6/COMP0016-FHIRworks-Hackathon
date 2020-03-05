/*
 * (C) Copyright IBM Corp. 2018, 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.compare_comply.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Termination dates identified in the input document.
 */
public class TerminationDates extends GenericModel {

  /**
   * The confidence level in the identification of the termination date.
   */
  public interface ConfidenceLevel {
    /** High. */
    String HIGH = "High";
    /** Medium. */
    String MEDIUM = "Medium";
    /** Low. */
    String LOW = "Low";
  }

  @SerializedName("confidence_level")
  protected String confidenceLevel;
  protected String text;
  @SerializedName("text_normalized")
  protected String textNormalized;
  @SerializedName("provenance_ids")
  protected List<String> provenanceIds;
  protected Location location;

  /**
   * Gets the confidenceLevel.
   *
   * The confidence level in the identification of the termination date.
   *
   * @return the confidenceLevel
   */
  public String getConfidenceLevel() {
    return confidenceLevel;
  }

  /**
   * Gets the text.
   *
   * The termination date.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the textNormalized.
   *
   * The normalized form of the termination date, which is listed as a string. This element is optional; it is returned
   * only if normalized text exists.
   *
   * @return the textNormalized
   */
  public String getTextNormalized() {
    return textNormalized;
  }

  /**
   * Gets the provenanceIds.
   *
   * Hashed values that you can send to IBM to provide feedback or receive support.
   *
   * @return the provenanceIds
   */
  public List<String> getProvenanceIds() {
    return provenanceIds;
  }

  /**
   * Gets the location.
   *
   * The numeric location of the identified element in the document, represented with two integers labeled `begin` and
   * `end`.
   *
   * @return the location
   */
  public Location getLocation() {
    return location;
  }
}
