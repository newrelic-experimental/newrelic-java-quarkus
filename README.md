<a href="https://opensource.newrelic.com/oss-category/#community-project"><picture><source media="(prefers-color-scheme: dark)" srcset="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/dark/Community_Project.png"><source media="(prefers-color-scheme: light)" srcset="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/Community_Project.png"><img alt="New Relic Open Source community project banner." src="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/Community_Project.png"></picture></a>

![GitHub forks](https://img.shields.io/github/forks/newrelic-experimental/newrelic-java-quarkus?style=social)
![GitHub stars](https://img.shields.io/github/stars/newrelic-experimental/newrelic-java-quarkus?style=social)
![GitHub watchers](https://img.shields.io/github/watchers/newrelic-experimental/newrelic-java-quarkus?style=social)

![GitHub all releases](https://img.shields.io/github/downloads/newrelic-experimental/newrelic-java-quarkus/total)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/newrelic-experimental/newrelic-java-quarkus)
![GitHub last commit](https://img.shields.io/github/last-commit/newrelic-experimental/newrelic-java-quarkus)
![GitHub Release Date](https://img.shields.io/github/release-date/newrelic-experimental/newrelic-java-quarkus)


![GitHub issues](https://img.shields.io/github/issues/newrelic-experimental/newrelic-java-quarkus)
![GitHub issues closed](https://img.shields.io/github/issues-closed/newrelic-experimental/newrelic-java-quarkus)
![GitHub pull requests](https://img.shields.io/github/issues-pr/newrelic-experimental/newrelic-java-quarkus)
![GitHub pull requests closed](https://img.shields.io/github/issues-pr-closed/newrelic-experimental/newrelic-java-quarkus) 


# New Relic Java Instrumentation for the Quarkus Framework

Provides instrumentation for the Quarkus framework.  This includes the following Quarkus implemented frameworks: Resteasy, Resteasy Reactive and Vert.x

# Installation

## Instructions for Using This Instrumentation

1. **Download the Latest Release**
   - Ensure you have the latest version of the following instrumentation pacakges :
   - [Quarkus](https://github.com/newrelic-experimental/newrelic-java-quarkus/releases)
   - [Smallrye](https://github.com/newrelic-experimental/newrelic-java-smallrye/releases)
   - [Jboss executors ](https://github.com/newrelic-experimental/newrelic-java-jboss-executors/releases)
   - [Vertx](https://github.com/newrelic/newrelic-java-vertx/releases)

2. **Prepare the New Relic Java Agent Directory**
   - Navigate to the New Relic Java Agent directory where `newrelic.jar` is located.
   - If it doesn't already exist, create a directory named `extensions` within the Java Agent directory.

3. **Copy the JAR Files**
   - Copy the JAR files from the downloaded release into the newly created `extensions` directory.

4. **Restart Your Application**
   - Restart your application to apply the new instrumentation.

5. **Run Transactions**
   - Execute the transactions you want to monitor.

6. **Verify in New Relic**
   - Go to the 'APM and Services' tab in New Relic.
   - Explore the 'Transactions' and 'Distributed Traces' sections to view traces related to your application.


## Building

If you make changes to the instrumentation code and need to build the instrumentation jars, follow these steps
1. Set environment variable NEW_RELIC_EXTENSIONS_DIR.  Its value should be the directory where you want to build the jars (i.e. the extensions directory of the Java Agent).   
2. Build one or all of the jars.   
a. To build one jar, run the command:  gradlew _moduleName_:clean  _moduleName_:install    
b. To build all jars, run the command: gradlew clean install
3. Restart the application

## Support

New Relic has open-sourced this project. Issues and contributions should be reported to the project here on GitHub.

## Contributing

We encourage your contributions to improve Salesforce Commerce Cloud for New Relic Browser! Keep in mind when you submit your pull request, you'll need to sign the CLA via the click-through using CLA-Assistant. You only have to sign the CLA one time per project. If you have any questions, or to execute our corporate CLA, required if your contribution is on behalf of a company, please drop us an email at opensource@newrelic.com.

**A note about vulnerabilities**

As noted in our [security policy](../../security/policy), New Relic is committed to the privacy and security of our customers and their data. We believe that providing coordinated disclosure by security researchers and engaging with the security community are important means to achieve our security goals.

If you believe you have found a security vulnerability in this project or any of New Relic's products or websites, we welcome and greatly appreciate you reporting it to New Relic through [HackerOne](https://hackerone.com/newrelic).

## License

New Relic Java Instrumentation for Quarkus is licensed under the [Apache 2.0](http://apache.org/licenses/LICENSE-2.0.txt) License.
