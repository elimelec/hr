Configurare Glassfish

1. Porniti GS din NB, tabul Services -> Servers -> GlassFish; right click si view admin console 

2. In GS console Configurations -> server-config -> security -> Realms -> New
	creati REALM cu datele din imaginea atasata; restul campurilor le lasati 		goale

3. In GS console Configurations -> server-config -> security
	setati proprietatea Default Realm pe cel adaugat nou, JDBCRealm


am pus rolul intr-o noua coloana in tabelul Users, numita permisiuni

In proiect pentru a adauga noi roluri si a le pune pe servleturi:

IN proiectul HR-WAR -> Configuration Files ->

in fisierul glassfish-web.xml, pentru fiecare ROL care il veti introduce pune o chestie de genul

    	<security-role-mapping>
        	 <role-name>ROL1</role-name>
	        <principal-name>ROL1</principal-name>
	        <group-name>ROL1</group-name>
   	</security-role-mapping>

	<security-role-mapping>
        	<role-name>ROL2</role-name>
        	<principal-name>ROL2</principal-name>
        	<group-name>ROL2</group-name>
    	</security-role-mapping>

	Aici in final vor fi toate rolurile din aplicatie

in fisierul web.xml :

    <security-constraint>
        <display-name>Constrangere1</display-name>
        <web-resource-collection>
            <web-resource-name> Constrangere1 </web-resource-name>
            <description/>
            	<url-pattern>/urlPath1</url-pattern>
		<url-pattern>/urlPath2</url-pattern>
            <http-method>GET</http-method>
            <http-method>POST</http-method>
        </web-resource-collection>
        <auth-constraint>
            <description/>
            	<role-name>ROL1</role-name>
		<role-name>ROL2</role-name>		
        </auth-constraint>
    </security-constraint>



cu urmatoarele semnificatii:
	display-name si web-resource-name nu cred ca au importanta; descrieti si voi ce constrangere este

	pentru fiecare servlet aveti o adnotare cu @WebServlet(“/urlPath1”) in care spuneti pentru care url path va raspunde servletul respectiv pe metodele get/post.

	Pentru a pune o anumita constrangere pe un servlet, il adugati ca si proprietate cu tag-urile
	<url-pattern>

	Pentru a adauga roluri la o constrangere adaugati rolul ca si proprietate cu tag-urile
	<role-name>


Explicatie pentru web.xml

	se defineste o constrangere de securitate numita Constrangere1

	Ea se aplica pe toate paginile ce contin in url /urlPath1 sau /urlPath2 (asta e cel pus cu 	adnotatia @WebServlet)
	
	
	Rolurile care au acces pe aceste pagini sunt ROL1 si ROL2



Cand introduceti/(facei update la) parolele in db pana facem o pagina pentru inserare useri pentru rolul admin; criptatile cu SHA-256 cu hex encoding

puteti folosi http://approsto.com/sha-generator/  

exp pentru 1234 sha-256 hex hash este 03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4




