<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <xsl:element name="Hardware">
            <xsl:apply-templates select="//Maquina"/>
        </xsl:element>
    </xsl:template>
    <xsl:template match="//Maquina">
        <xsl:element name="Maquina">
            <xsl:attribute name="fabr">
                <xsl:value-of select="Info/Fabricante"/>
            </xsl:attribute>
            <xsl:if test="Notas">
                <xsl:comment>
                    <xsl:value-of select="Notas"/>
                </xsl:comment>
            </xsl:if>
            <xsl:element name="Nome"> 
                <xsl:value-of select="concat(@Nome, ' (', Info/Tipo, ')')"/>
            </xsl:element>
            <xsl:element name="Capacidade">
                <xsl:attribute name="tecnoloxía">
                    <xsl:value-of select="Info/Disco/@Tecnoloxía"/>
                </xsl:attribute>
                <xsl:value-of select="sum(Info/Disco/@Capacidade)"/>
            </xsl:element>    
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>