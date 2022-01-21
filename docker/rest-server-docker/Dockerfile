FROM tomcat:9.0

WORKDIR $CATALINA_HOME

# We use the version 10.0.2 but this can be overridden with a build arg.
# Note that the syntax of the URL is not totally consistent between versions.
ARG KEYCLOAK_URL=https://github.com/keycloak/keycloak/releases/download/16.1.0/keycloak-oidc-tomcat-adapter-16.1.0.tar.gz

RUN mkdir keycloak && cd keycloak && wget -O keycloak.tar.gz\
    ${KEYCLOAK_URL} &&\
    tar xfz keycloak.tar.gz &&\
    rm keycloak.tar.gz &&\
    mv *.jar $CATALINA_HOME/lib &&\
    cd $CATALINA_HOME && rm -rf keycloak

COPY java-restserver.war $CATALINA_HOME/webapps/