<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<!-- variable that holds regular number of hours per week -->
<xsl:variable name="basicweeklyhours" select="40"/>

    <xsl:template match="/">
        <html>
            <body>
                Total Number of Employees: <xsl:value-of select="count(employees/employee)"/> <br/>
                Number of Employees that worked overtime: <xsl:value-of select="count(employees/employee[hoursworked>=40])"/> <br/>
                <p></p>
                <table border="1">
                    <tr><th colspan="7">Weeky Payroll</th></tr>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Hourly Rate</th>
                        <th>Hours Worked</th>
                        <th>Regular Pay</th>
                        <th>Overtime</th>
                        <th>Total Pay</th>
                    </tr>
                    <xsl:apply-templates select="employees/employee"/>
                    <tr>
                        <th colspan="6" align="right">Grand Total</th>
                        <td>
                            <xsl:call-template name="grandtotal">
                                <xsl:with-param name="employeeList" select="employees/employee"/>
                            </xsl:call-template>
                        </td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>

    <!-- start of employee template -->
    <xsl:template match="employee">
        <tr>
            <td><xsl:value-of select="@id"/></td>
            <td><xsl:value-of select="normalize-space(name)"/></td>
            <td><xsl:value-of select="hourlyrate"/></td>
            <td><xsl:value-of select="hoursworked"/></td>
            
            <!-- Overtime -->
            <xsl:variable name="overtime">
                <xsl:if test="hoursworked > $basicweeklyhours">
                    <xsl:value-of select="(hoursworked - $basicweeklyhours)*1.5 * hourlyrate"/>
                </xsl:if>
                <xsl:if test="hoursworked &lt;= $basicweeklyhours">
                    <xsl:value-of select="0"/>
                </xsl:if>
            </xsl:variable>

            <!-- Regular pay -->
            <xsl:variable name="regularpay">
                <xsl:if test="hoursworked > $basicweeklyhours">
                    <xsl:value-of select="$basicweeklyhours * hourlyrate"/>
                </xsl:if>
                <xsl:if test="hoursworked &lt;= $basicweeklyhours">
                    <xsl:value-of select="hoursworked * hourlyrate"/>
                </xsl:if>
            </xsl:variable>

            <td><xsl:value-of select="format-number($regularpay,'$###,###,###.00')"/></td>
            <td><xsl:value-of select="format-number($overtime,'$###,###,##0.00')"/></td>
            <td><xsl:value-of select="format-number($regularpay + $overtime,'$###,###,###.00')"/></td>
        </tr>
    </xsl:template>
    <!-- end of employee template -->

    <!-- start of grandtotoal template -->
    <xsl:template name="grandtotal">
        <xsl:param name="employeeList"/>
        <xsl:param name="totalpay" select="0"/>

        <!-- going through all employees -->
        <xsl:choose>
            <xsl:when test="$employeeList">
                <!-- calculating employee pay -->
                <!-- create a variable that holds the employee pay -->
                <xsl:variable name="employeepay">
                    <xsl:if test="$employeeList[1]/hoursworked &lt;=40">
                        <xsl:value-of select="$employeeList[1]/hourlyrate * $employeeList[1]/hoursworked"/>
                    </xsl:if>
                    <xsl:if test="$employeeList[1]/hoursworked > 40">
                        <xsl:value-of select="(40 * $employeeList[1]/hourlyrate) + ($employeeList[1]/hoursworked
                        - 40)*1.5*$employeeList[1]/hourlyrate"/>
                    </xsl:if>
                </xsl:variable>
 
                <!-- call the template again (recursively) -->
                <xsl:call-template name="grandtotal">
                    <xsl:with-param name="employeeList" select="$employeeList[position() > 1]"/>
                    <xsl:with-param name="totalpay" select="$employeepay + $totalpay"/>
                </xsl:call-template>

                
            </xsl:when>
            <xsl:otherwise>
                <!-- ready to display the totalpay -->
                <xsl:value-of select="format-number($totalpay,'$###,###.00')"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

    <!-- end of grandtotoal template -->
</xsl:stylesheet>
