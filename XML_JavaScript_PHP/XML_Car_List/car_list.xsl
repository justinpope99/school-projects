<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<!-- start of root template -->
    <xsl:template match="/">
        <html>
        <head>
            <link rel="stylesheet" type="text/css" href="car_list.css"/>
        </head>
            <body>
                <h2>1. Inventory (all cars)</h2>
                <table border="1">
                <xsl:call-template name="initialtable"/>
                    <xsl:apply-templates select="cars/car"/>
                    </table>
                    <hr/>
                    <h2>2. All the information for cars before 2022</h2>
                <table border="1"> 
                    <xsl:call-template name="initialtable"/>
                    <xsl:apply-templates select="cars/car[year &lt; 2022]"/>
                 </table>
                 <hr/>
                 <h2>3. All the information for on Mustang cars</h2>
                <table border="1">
                    <xsl:call-template name="initialtable"/>
                    <xsl:apply-templates select="cars/car[contains(model, 'Mustang') or
                    translate(model, 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQQRSTUVWXYZ')='MUSTANG']"/>
                 </table>
                 <hr/>
                 <h2>4. All the information on Buick Encore cars</h2>
                 <table border="1">
                    <xsl:call-template name="initialtable"/>
                    <xsl:apply-templates select="cars/car[contains(model, 'Encore') or
                    translate(model, 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQQRSTUVWXYZ')='BUICK ENCORE']"/>
                 </table>
                 <hr/>
                 <h2>5. All the information on cars before 2020</h2>
                 <table border="1">
                    <xsl:call-template name="initialtable"/>
                    <xsl:apply-templates select="cars/car[year &lt; 2020]"/>
                 </table>
            </body>
        </html>
    </xsl:template>
    <!-- end of root template -->

    <!-- start of initialtable template-->
    <xsl:template name="initialtable">
                    <tr>
                        <th>Make</th>
                        <th>Model</th>
                        <th>Year</th>
                        <th>Picture</th>
                    </tr>
    </xsl:template>
    <!-- end of initialtable template-->

    <!-- start of car template -->
    <xsl:template match="car">
        <tr>
            <td><xsl:value-of select="make"/></td>
            <td><xsl:value-of select="model"/></td>
            <td><xsl:value-of select="year"/></td>
            <td><img src="{pic}" height="200" width="200"/></td>
        </tr>
    </xsl:template>
    <!-- end of car template-->
</xsl:stylesheet>