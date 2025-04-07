package org.company.utils

class GitUtils implements Serializable {
    def steps

    GitUtils(steps) {
        this.steps = steps
    }

    def shortCommitHash() {
        return steps.sh(script: "git rev-parse --short HEAD", returnStdout: true).trim()
    }
}
