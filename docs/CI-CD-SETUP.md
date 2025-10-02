# CI/CD Setup Guide

This document explains how to set up and use the CI/CD pipeline for the Chess Game project.

## GitHub Actions Workflow

The project uses GitHub Actions for continuous integration and deployment:

### Maven Build Workflow

**File**: `.github/workflows/maven.yml`

This workflow handles the core build process:

- Triggers on pushes to main branch and pull requests
- Sets up Java 17 environment
- Builds the project with Maven
- Runs all tests
- Uploads build artifacts

## Setup Instructions

### Getting Started

1. Ensure you have GitHub Actions enabled for your repository
2. The workflow will automatically run when you push to the main branch or create a pull request

### Customizing the Workflow

You can customize the workflow by editing the YAML file:

- Adjust the Java version if needed
- Modify the Maven build commands
- Change the branches that trigger the workflow
- Add additional steps for deployment

## Workflow Status

You can check the status of your workflow in the "Actions" tab of your GitHub repository. Each workflow run will show:

- Build status (success/failure)
- Test results
- Any errors or warnings

## Badge

The README includes a status badge that automatically updates to reflect the current state of your CI/CD pipeline:

- Build Status Badge: Shows if the latest build passed or failed

## Best Practices

1. Always run tests locally before pushing changes
2. Keep dependencies updated
3. Review workflow logs for any warnings or optimizations
