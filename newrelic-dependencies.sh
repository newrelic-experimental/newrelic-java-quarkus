#!/bin/bash -e

if [ ! -d "libs" ];
then
    mkdir libs
fi


AGENT_DOWNLOADED="libs/newrelic-agent-*.jar"

AGENT_BRIDGE_LIBS="libs/agent-bridge.jar"
AGENT_BRIDGE_DS_LIBS="libs/agent-bridge-datastore.jar"

function checkForFiles {
    if [ ! -f $AGENT_BRIDGE_LIBS ];
    then
      getAgentBridge
    fi
    if [ ! -f $AGENT_BRIDGE_DS_LIBS ];
    then
      getAgentBridgeDatastore
    fi
}

function downloadAgent {
  ./gradlew getAgent
  ./gradlew extractJars
  ./gradlew cleanUp
}

function getAgentBridge {
  if [ ! -f $AGENT_DOWNLOADED ];
  then
    downloadAgent
  fi
  if [ ! -f $AGENT_BRIDGE_LIBS ];
  then
    echo "Download of Agent and extraction of Agent Bridge failed"
  fi
}

function getAgentBridgeDatastore {
  if [ ! -f $AGENT_DOWNLOADED ];
  then
    downloadAgent
  fi
  if [ ! -f $AGENT_BRIDGE_DS_LIBS ];
  then
    echo "Download of Agent and extraction of Agent Bridge Datastore failed"
  fi
}

checkForFiles
