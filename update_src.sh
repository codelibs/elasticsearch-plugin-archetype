#!/bin/bash

JAVA_SRC_DIR=../elasticsearch-plugin-sample/src/main/java/org/codelibs/elasticsearch/sample/
JAVA_DIR=src/main/resources/archetype-resources/src/main/java
for file in `find $JAVA_SRC_DIR -type f` ; do
    JAVA_FILE=`echo $file | sed -e "s,$JAVA_SRC_DIR,,"`
    JAVA_NEW_FILE=`echo $JAVA_DIR/$JAVA_FILE | sed -e 's/Sample/__pluginName__/g'`
    JAVA_BASE_DIR=`dirname $JAVA_NEW_FILE`
    echo "Creating $JAVA_NEW_FILE"
    mkdir -p $JAVA_BASE_DIR
    sed \
         -e 's/org.codelibs.elasticsearch.sample/\${package}/g' \
         -e 's/Sample/\${pluginName}/g' \
         -e 's/_sample/_\${restName}/g' \
         -e 's/registerRiver("sample/registerRiver("\${riverName}/g' \
         -e 's/sample/\${artifactId}/g' \
        $file > $JAVA_NEW_FILE
done

ASSEMBLY_FILE=../elasticsearch-plugin-sample/src/main/assemblies/plugin.xml
ASSEMBLY_DIR=src/main/resources/archetype-resources/src/main/assemblies
mkdir -p $ASSEMBLY_DIR
echo "Creating $ASSEMBLY_DIR/plugin.xml"
cp $ASSEMBLY_FILE $ASSEMBLY_DIR/plugin.xml

PROP_FILE=../elasticsearch-plugin-sample/src/main/resources/es-plugin.properties
PROP_DIR=src/main/resources/archetype-resources/src/main/resources
mkdir -p $PROP_DIR
echo "Creating $PROP_DIR/es-plugin.properties"
sed \
    -e 's/org.codelibs.elasticsearch.sample/\${package}/g' \
    -e 's/Sample/\${pluginName}/g' \
    $PROP_FILE > $PROP_DIR/es-plugin.properties

THIS_YEAR=`date '+%Y'`
POM_FILE=../elasticsearch-plugin-sample/pom.xml
POM_DIR=src/main/resources/archetype-resources
echo "Creating $POM_DIR/pom.xml"
echo "#set(\$dollar = '\$')##" > $POM_DIR/pom.xml
sed \
    -e '/^<!-- CODELIBS: BEGIN -->$/,/^<!-- CODELIBS: END -->$/d' \
    -e 's/\$/\${dollar}/g' \
    -e 's/org.codelibs.elasticsearch/\${package}/g' \
    -e 's/org.codelibs/\${groupId}/g' \
    -e 's/Sample/\${pluginName}/g' \
    -e 's/elasticsearch-plugin-sample/\${artifactId}/g' \
    -e 's/sample/\${artifactId}/g' \
    -e 's/<version>1.1.0-SNAPSHOT</<version>\${version}</g' \
    -e 's/<elasticsearch.version>.*</<elasticsearch.version>\${elasticsearchVersion}</g' \
    -e "s/<inceptionYear>.*</<inceptionYear>$THIS_YEAR</g" \
    $POM_FILE >> $POM_DIR/pom.xml

