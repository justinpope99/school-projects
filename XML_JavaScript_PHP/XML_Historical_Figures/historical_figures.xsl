<?xml version="1.0"?>
<xsl:stylesheet version ="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <!-- start of root template -->
    <xsl:template match="/">
        <!--  start Web page -->
        <html>
            <body>
                <h2>Historical Figures</h2>
                1. All Information
                <table border="1">
                    <xsl:call-template name="createcolumns"/>
                    <xsl:apply-templates select="persons/person"/>
                 </table>
                 <hr/>
                 2. All USA Historical Figures
                <table border="1">
                    <xsl:call-template name="createcolumns"/>
                    <xsl:apply-templates select="persons/person[translate(Nationality, 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ')='USA']"/>
                 </table>
                 <hr/>
                 3. All information of historical figures that were politician
                <table border="1">
                    <xsl:call-template name="createcolumns"/>
                    <xsl:apply-templates select="persons/person[contains(translate(Profession, 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'POLITICIAN')]"/>
                 </table>
                 <hr/>
                 4. All information of historical figures from either India or Pakistan
                <table border="1">
                    <xsl:call-template name="createcolumns"/>
                    <xsl:apply-templates select="persons/person[contains(translate(Nationality, 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'INDIA') or
                    contains(translate(Nationality, 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'PAKISTAN')]"/>
                 </table>
            </body>
        </html>
    </xsl:template>
    <!-- end of root template -->

    <!-- start of createtable template -->
    <xsl:template name="createcolumns">
            <tr>
                <th>Name</th>
                <th>Profession</th>
                <th>Nationality</th>
                <th>Picture</th>
            </tr>
    </xsl:template>
    <!-- end of createtable template-->

    <!-- start of person template -->
    <xsl:template match="person">
        <tr>
            <td><xsl:value-of select="Name"/></td>
            <td><xsl:value-of select="Profession"/></td>
            <td><xsl:value-of select="Nationality"/></td>
            <td><img src="{Picture}" width="50" 
                height="100"/></td>
        </tr>
    </xsl:template>
    <!-- end of person template -->
</xsl:stylesheet>