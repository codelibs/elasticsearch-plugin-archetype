Elasticsearch Plugin Archetype
==============================

## Overview

This project (elasticsearch-plugin-archetype) provides Maven archetype for Elasticsearch plugin.
You can easily create your elasticsearch plugin by this archetype.

## Version

| River Web | elasticsearch |
|:---------:|:-------------:|
| master    | 1.0.0.X       |
| 1.2.0     | 1.2.1         |
| 1.1.0     | 1.0.0.RC2     |
| 1.0.0     | 0.90.5        |

## Usage

Using archetype:generate goal of Maven, run the following command:

    $ mvn archetype:generate \
        -DarchetypeGroupId=org.codelibs \
        -DarchetypeArtifactId=elasticsearch-plugin-archetype \
        -DarchetypeVersion=1.2.0 \
        -DelasticsearchVersion=1.2.1 \
        -DgroupId=<Your groupId> \
        -DartifactId=<your artifactId> \
        -Dversion=<your version> \
        -DpluginName=<your plugin name> \
        -DrestName=<your rest API name> \
        -DriverName=<your river name> 

Properties description is below:

| Property Name        | Description           | Example             |
|:--------------------:|:---------------------:|:-------------------:|
| elasticsearchVersion | Elasticsearch version | 1.0.0.RC2           |
| groupId              | Project's groupId     | com.example         |
| artifactId           | Project's artifactid  | elasticsearch-hello |
| version              | Project's version     | 1.0-SNAPSHOT        |
| pluginName           | Plugin class name     | Hello               |
| restName             | Rest API name         | hello               |
| riverName            | River name            | hello               |

elasticsearchVersion and restName are optional.

For example, the command is below:

    $ mvn archetype:generate \
        -DarchetypeGroupId=org.codelibs \
        -DarchetypeArtifactId=elasticsearch-plugin-archetype \
        -DarchetypeVersion=1.2.0 \
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

## To Create River

A river component is generated as \<pluginName\>RiverModule and \<pluginName\>River.
You can put your code into \<pluginName\>River.
To register your river, 

    $ curl -XPUT 'localhost:9200/_river/my_river/_meta' -d '{
        "type" : "<riverName>"
    }'

If a river is not necessary, remove \<pluginName\>RiverModule, \<pluginName\>River and the definistion in \<pluginName\>Plugin class.

