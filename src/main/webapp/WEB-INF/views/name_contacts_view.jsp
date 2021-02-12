<%@ page import="org.example.contactbookspring.entities.Contact" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
%>
<html>
<head>
    <title>Совпадение в имени</title>
    <style>
        .borderElement {
            width: 100px;
            height: 15px;
            align-items: center;
            background-color: #EEDDFF;
            border: 3px solid #7922CC;
            border-radius: 25px;
            text-align: center;
            vertical-align: middle;
            padding: 5px;
        }
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<%for (Contact contact : contacts) { %>

<div class="text">
    <div class="id"><%=contact.getId()%>
    </div>
    <div class="name"><%=contact.getName()%>
    </div>
    <div class="phone"><%=contact.getNumber()%>
    </div>
    <div class="borderElement">
        <a href=" /contactbookspring">на главную</a>
    </div>
</div>

<% }%>


</body>
</html>
