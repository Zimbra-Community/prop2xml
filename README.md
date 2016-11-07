# prop2xml
A java command line tool to convert a .properties file to a Zimlet config_template.xml

# usage

    java -jar prop2xml.jar rootelem /tmp/newconfig.properties /tmp/config_template.xml
    
# input
    
     /tmp/newconfig.properties
     key=value
    
# output
 
    /tmp/config_template.xml
    <?xml version="1.0" encoding="UTF-8"?>
    <!--
    DO NOT MANUALLY CHANGE THIS FILE
    Please read the documentation.
    -->
    <zimletConfig name="rootelem" version="1.0"><global>
    <property name="key">value</property>
    </global></zimletConfig>
