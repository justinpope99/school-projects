<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                Number of Employees that worked overtime: <xsl:value-of select="count(employees/employee[hoursworked>=40])"/>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>