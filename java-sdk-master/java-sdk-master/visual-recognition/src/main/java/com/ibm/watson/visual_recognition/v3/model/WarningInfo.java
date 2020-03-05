/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
package com.ibm.watson.visual_recognition.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information about something that went wrong.
 */
public class WarningInfo extends GenericModel {

  @SerializedName("warning_id")
  protected String warningId;
  protected String description;

  /**
   * Gets the warningId.
   *
   * Codified warning string, such as `limit_reached`.
   *
   * @return the warningId
   */
  public String getWarningId() {
    return warningId;
  }

  /**
   * Gets the description.
   *
   * Information about the error.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }
}
