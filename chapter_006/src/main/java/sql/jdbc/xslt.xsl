<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output method="xml" indent="yes"/>
		<xsl:template match="/">
			<entries>
				<xsl:for-each select="entries/entry">
					<entry field="{field}"/>
				</xsl:for-each>
			</entries>
		</xsl:template>
</xsl:stylesheet>
