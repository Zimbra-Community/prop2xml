#!/bin/bash

# We only support java versions bundled with Zimbra
if [[ -x "/opt/zimbra/common/bin/java" ]]
then
   #8.7
    [[ ":$PATH:" != *":/opt/zimbra/common/bin:"* ]] && PATH="/opt/zimbra/common/bin:${PATH}"
    export PATH
elif  [[ -x "/opt/zimbra/java/bin/java" ]]
then
    #8.6
    [[ ":$PATH:" != *":/opt/zimbra/java/bin:"* ]] && PATH="/opt/zimbra/java/bin:${PATH}"
    export PATH
else
    echo "Java is not found in /opt/zimbra"
    exit 1
fi
