Elasticsearch Plugin Archetype
==============================

## Overview

This project (elasticsearch-plugin-archetype) provides Maven archetype for Elasticsearch plugin.
You can easily create your elasticsearch plugin by this archetype.

## Version

| Version   | elasticsearch |
|:---------:|:-------------:|
| master    | 1.5.X         |
| 1.5.0     | 1.5.2         |
| 1.4.0     | 1.4.0.Beta1   |
| 1.3.0     | 1.3.0         |
| 1.2.0     | 1.2.1         |
| 1.1.0     | 1.0.0.RC2     |
| 1.0.0     | 0.90.5        |


### Issues/Questions

Please file an [issue](https://github.com/codelibs/elasticsearch-plugin-archetype/issues "issue").
(Japanese forum is [here](https://github.com/codelibs/codelibs-ja-forum "here").)

## Usage

Using archetype:generate goal of Maven, run the following command:

    $ mvn archetype:generate \
        -DarchetypeGroupId=org.codelibs \
        -DarchetypeArtifactId=elasticsearch-plugin-archetype \
        -DarchetypeVersion=1.5.0 \
        -DelasticsearchVersion=1.5.2 \
        -DgroupId=<Your groupId> \
        -DartifactId=<your artifactId> \
        -Dversion=<your version> \
        -DpluginName=<your plugin name> \
        -DrestName=<your rest API name>

Properties description is below:

| Property Name        | Description           | Example             |
|:--------------------:|:---------------------:|:-------------------:|
| elasticsearchVersion | Elasticsearch version | 1.5.2               |
| groupId              | Project's groupId     | com.example         |
| artifactId           | Project's artifactid  | elasticsearch-hello |
| version              | Project's version     | 1.0-SNAPSHOT        |
| pluginName           | Plugin class name     | Hello               |
| restName             | Rest API name         | hello               |

elasticsearchVersion and restName are optional.

For example, the command is below:

    $ mvn archetype:generate \
        -DarchetypeGroupId=org.codelibs \
        -DarchetypeArtifactId=elasticsearch-plugin-archetype \
        -DarchetypeVersion=1.5.0 \
        -DgroupId=com.example \
        -DartifactId=elasticsearch-hello \
        -Dversion=1.0-SNAPSHOT \
        -DpluginName=Hello 

## To Create Service

A service component is generated as \<pluginName\>Module and \<pluginName\>Service classes.
You can put your code into \<pluginName\>Service.
\<pluginName\>Service is injected to other components in elasticsearch.

If a service is not necessary, remove \<pluginName\>Module, \<pluginName\>Service and the definistion in \<pluginName\>Plugin class.

## To Create Rest API

A class file for Rest API is \<pluginName\>RestAction.
You can put your code into \<pluginName\>RestAction.
The urls to access to \<pluginName\>RestAction are:

    http://localhost:9200/{index}/{type}/_<restName>
    http://localhost:9200/{index}/_<restName>

The definistion is in a constructor of \<pluginName\>RestAction.

If a rest API is not necessary, remove \<pluginName\>RestAction class and the definistion in \<pluginName\>Plugin class.

