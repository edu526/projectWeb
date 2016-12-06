<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html>
    <head>

        <title> HTML File example </title>
    <head>
    <body bgcolor="#DDDDDD">
        <h1> Struts html:file example </h1>

        <html:form action="/optaction" >
                <html:select name="optform" property="colors">
                    <html:options name="optform" property="colorlist" />
                </html:select><br>
        </html:form>

    </body>
</html>