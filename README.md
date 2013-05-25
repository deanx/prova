<font face="tahoma" size="2">
<b>I - Tecnologias utilizadas Java:</b><br/>
<ul>
 <li>Spring MVC</li>
 <li>Spring Security</li>
 <li>Spring Cache</li>
 <li>Hibernate</li>
 <li>H2 Database</li>
 <li>Twiter BootStrap</li>
 <li>Maven</li>
</ul>

<b>II - Tecnologias utilizadas NodeJS:</b><br/>
<ul>
 <li>Express</li>
 <li>MongoDB</li>
 <li>Nodeclipse (Eclipse Plugin)</li>
</ul>

<b>III - Infraestrutura:</b><br/>
<ul>
 <li>JBOSS AS 7.1 Final com Hibernate - https://www.dropbox.com/s/5fgzzthxj13peg2/jboss-as-7.1.1.Final.zip</li>
 <li>Eclipse Juno</li>
 <li>MongoDB</li>
 <li>NodeJS</li>
</ul>

<b>IV - Portas utilizadas durante desenvolvimento:</b><br/>
<ul>
 <li>JBOSS AS 7.1 Final - 8088</li>
 <li>MongoDB - 27017</li>
 <li>App NodeJS - 1337</li>
</ul>

<b>V - Processo para execu&ccedil;&atilde;o:</b><br/>
<ul>
 <li>Certificar-se que o Java está configurado, bem como o NodeJS e o MongoDB</li>
 <li>Baixar e descomprimir o Jboss AS 7.1 Final com Hibernate do link passado no Item 2</li>
 <li>Alterar o arquivo standalone.xml, localizado dentro do diret&oacute;rio standalone/configuration do JBOSS descomprimido, alterando a porta 8080 para 8088</li>
 <li>Copiar o arquivo prova.war, localizado na raiz do projeto prova, para o diret&oacute;rio standalone/deployments do JBOSS descomprimido</li>
 <li>Executar o arquivo standalone.(sh|bat) dentro do diret&oacute;rio bin do JBOSS descomprimido</li>
 <li>Executar o arquivo app.js, localizado na raiz do projeto provaNode, com o NodeJS</li>
 <li>Executar o browser e ir at&eacute; <a href="http://localhost:8088/prova">http://localhost:8088/prova</a></li>
 <li>Efetuar login com login:joao@silva.com.br  senha:xxx</li>
</ul>


</font>