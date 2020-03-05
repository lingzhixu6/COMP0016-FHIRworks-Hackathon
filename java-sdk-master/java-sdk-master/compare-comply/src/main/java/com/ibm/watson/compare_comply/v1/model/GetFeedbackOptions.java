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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getFeedback options.
 */
public class GetFeedbackOptions extends GenericModel {

  /**
   * The analysis model to be used by the service. For the **Element classification** and **Compare two documents**
   * methods, the default is `contracts`. For the **Extract tables** method, the default is `tables`. These defaults
   * apply to the standalone methods as well as to the methods' use in batch-processing requests.
   */
  public interface Model {
    /** contracts. */
    String CONTRACTS = "contracts";
    /** tables. */
    String TABLES = "tables";
  }

  protected String feedbackId;
  protected String model;

  /**
   * Builder.
   */
  public static class Builder {
    private String feedbackId;
    private String model;

    private Builder(GetFeedbackOptions getFeedbackOptions) {
      this.feedbackId = getFeedbackOptions.feedbackId;
      this.model = getFeedbackOptions.model;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param feedbackId the feedbackId
     */
    public Builder(String feedbackId) {
      this.feedbackId = feedbackId;
    }

    /**
     * Builds a GetFeedbackOptions.
     *
     * @return the getFeedbackOptions
     */
    public GetFeedbackOptions build() {
      return new GetFeedbackOptions(this);
    }

    /**
     * Set the feedbackId.
     *
     * @param feedbackId the feedbackId
     * @return the GetFeedbackOptions builder
     */
    public Builder feedbackId(String feedbackId) {
      this.feedbackId = feedbackId;
      return this;
    }

    /**
     * Set the model.
     *
     * @param model the model
     * @return the GetFeedbackOptions builder
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }
  }

  protected GetFeedbackOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.feedbackId,
        "feedbackId cannot be empty");
    feedbackId = builder.feedbackId;
    model = builder.model;
  }

  /**
   * New builder.
   *
   * @return a GetFeedbackOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the feedbackId.
   *
   * A string that specifies the feedback entry to be included in the output.
   *
   * @return the feedbackId
   */
  public String feedbackId() {
    return feedbackId;
  }

  /**
   * Gets the model.
   *
   * The analysis model to be used by the service. For the **Element classification** and **Compare two documents**
   * methods, the default is `contracts`. For the **Extract tables** method, the default is `tables`. These defaults
   * apply to the standalone methods as well as to the methods' use in batch-processing requests.
   *
   * @return the model
   */
  public String model() {
    return model;
  }
}
