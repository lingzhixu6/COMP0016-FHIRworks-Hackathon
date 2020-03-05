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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The results of a successful **Get Feedback** request for a single feedback entry.
 */
public class GetFeedback extends GenericModel {

  @SerializedName("feedback_id")
  protected String feedbackId;
  protected Date created;
  protected String comment;
  @SerializedName("feedback_data")
  protected FeedbackDataOutput feedbackData;

  /**
   * Gets the feedbackId.
   *
   * A string uniquely identifying the feedback entry.
   *
   * @return the feedbackId
   */
  public String getFeedbackId() {
    return feedbackId;
  }

  /**
   * Gets the created.
   *
   * A timestamp identifying the creation time of the feedback entry.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the comment.
   *
   * A string containing the user's comment about the feedback entry.
   *
   * @return the comment
   */
  public String getComment() {
    return comment;
  }

  /**
   * Gets the feedbackData.
   *
   * Information returned from the **Add Feedback** method.
   *
   * @return the feedbackData
   */
  public FeedbackDataOutput getFeedbackData() {
    return feedbackData;
  }
}
