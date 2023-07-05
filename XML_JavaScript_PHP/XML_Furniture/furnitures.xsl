<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Furniture</h2>
                <table border="1">
                    <tr>
                        <th>Piece Type</th>
                        <th>Units</th>
                        <th>Mass</th>
                        <th>Material Type</th>
                        <th>Dimensions</th>
                        <th>Price</th>
                        <th>Picture</th>
                    </tr>
                <xsl:for-each select="furnitures/furniture">
                    <tr>
                        <td><xsl:value-of select="Piece_Type"/></td>
                        <td><xsl:value-of select="Units"/></td>
                        <td><xsl:value-of select="Mass"/></td>
                        <td><xsl:value-of select="Material_Type"/></td>
                        <td><xsl:value-of select="Dimensions"/></td>
                        <td><xsl:value-of select="Price"/></td>
                        <td><img src="{Picture}" height="200" width="200"/></td>
                    </tr>
                </xsl:for-each>
                </table>
                <hr/>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
