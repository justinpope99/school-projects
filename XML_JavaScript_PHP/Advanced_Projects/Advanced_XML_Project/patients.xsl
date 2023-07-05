<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <img src="logo.png"/>
                <h2>All Patient Information</h2>
                <table border="1">
                    <tr>
                        <th>Patient ID</th>
                        <th>On Study</th>
                        <th>Last Name</th>
                        <th>First Name</th>
                        <th>Date of Birth</th>
                        <th>Age</th>
                        <th>Stage</th>
                        <th>Comment</th>
                        <th>Performance Scale</th>
                        <th>Performance</th>
                    </tr>
                <xsl:for-each select="patients/patient">
                    <tr>
                        <td><xsl:value-of select="@patID"/></td>
                        <td><xsl:value-of select="@onStudy"/></td>
                        <td><xsl:value-of select="lastName"/></td>
                        <td><xsl:value-of select="firstName"/></td>
                        <td><xsl:value-of select="dateOfBirth"/></td>
                        <td><xsl:value-of select="age"/></td>
                        <td><xsl:value-of select="stage"/></td>
                        <td><xsl:value-of select="comment"/></td>
                        <td><xsl:value-of select="performance/@scale"/></td>
                        <td><xsl:value-of select="performance"/></td>
                    </tr>
                </xsl:for-each>
                </table>
                <br/>
                <hr/>
                <h2>Patients born between the months of December and March</h2>
                <xsl:for-each select="patients/patient">
                <xsl:if test="contains(dateOfBirth, '-12-') or contains(dateOfBirth, '-01-') or
                contains(dateOfBirth, '-02-') or contains(dateOfBirth, '-03-')">
                <xsl:value-of select="lastName"/>,&#160; 
                <xsl:value-of select="firstName"/>
                <br/>
                </xsl:if>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>