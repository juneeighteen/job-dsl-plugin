package javaposse.jobdsl.dsl.helpers.step

import javaposse.jobdsl.dsl.Context

class ParameterizedRemoteTriggerContext implements Context {
    Map<String, String> parameters = [:]
    boolean shouldNotFailBuild = false
    int pollInterval = 10
    boolean preventRemoteBuildQueue = false
    boolean blockBuildUntilComplete = false
    boolean enhancedLogging = false
    String token

    /**
     * Adds a parameter value for the remote job. Can be called multiple times to add more parameter values.
     */
    void parameter(String name, String value) {
        this.parameters[name] = value
    }

    /**
     * Adds parameter values for the remote job. Can be called multiple times to add more parameter values.
     */
    void parameters(Map<String, String> parameters) {
        this.parameters.putAll(parameters)
    }

    /**
     * If set, a failure of the remote job will not fail this job. Defaults to {@code false}.
     */
    void shouldNotFailBuild(boolean shouldNotFailBuild = true) {
        this.shouldNotFailBuild = shouldNotFailBuild
    }

    /**
    * If set, enables enhanced logging. Defaults to {@code false}.
    */
    void enhancedLogging(boolean enhancedLogging = true) {
      this.enhancedLogging = enhancedLogging
    }

    /**
     * Sets the poll interval in seconds. Defaults to 10 seconds.
     *
     * @since 1.29
     */
    void pollInterval(int pollInterval) {
        this.pollInterval = pollInterval
    }

    /**
     * If set, waits to trigger remote builds until no other builds are running. Defaults to {@code false}.
     *
     * @since 1.29
     */
    boolean preventRemoteBuildQueue(boolean preventRemoteBuildQueue = true) {
        this.preventRemoteBuildQueue = preventRemoteBuildQueue
    }

    /**
     * Blocks the job until the remote triggered projects finish their builds. Defaults to {@code false}.
     *
     * @since 1.29
     */
    boolean blockBuildUntilComplete(boolean blockUntilBuildComplete = true) {
        this.blockBuildUntilComplete = blockUntilBuildComplete
    }

    /**
     * Sets a security token which is defined on the job of the remote Jenkins host.
     *
     * For security reasons, do not use a hard-coded token. See
     * <a href="https://github.com/jenkinsci/job-dsl-plugin/wiki/Handling-Credentials">Handling Credentials</a> for
     * details about handling credentials in DSL scripts.
     *
     * @since 1.38
     */
    void token(String token) {
        this.token = token
    }
}
