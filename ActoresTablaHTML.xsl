<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <xsl:apply-templates />
        </html>
    </xsl:template>
    <xsl:template match="Actores">
        <head>
            <title>LISTADO DE ACTORES</title>
        </head>
        <body>
            <h1>Lista de actores</h1>
            <table border="1">
                <tr>
                    <th>Nombre</th>
                    <th>Sexo</th>
                    <th>Data de nacemento</th>
                </tr>
                <xsl:apply-templates select="Actor"/>
            </table>
        </body>
    </xsl:template>
    <xsl:template match="Actor">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="Nome|Sexo|DataNacemento">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
</xsl:stylesheet>