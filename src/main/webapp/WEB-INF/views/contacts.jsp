<%@ page import="org.example.contactbookspring.entities.Contact" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
%>

<html>
<head>
    <title>Title</title>
    <style>
        .contact {
            padding: 20px;
            background-color: #369;
            margin: 10px 20px;
            border: 3px solid red;
            display: block;
        }

        .contact * {
            color: azure;
        }

        .contact form * {
            color: black;
        }

        .text {
            margin-left: auto;
            margin-right: auto;
            width: 500px;
        }

        .communicator {
            display: flex;
            align-items: center;
            justify-content: space-around;
            border: 2px solid red;
            padding: 20px;
            margin: 20px;
            background-color: #336699;
        }

        .cell {
            width: 250px;
            height: 200px;
            border: 2px solid red;
            padding: 20px;
            margin: 20px;
            background-color: bisque;
        }

        h3 {
            margin-left: 60px;
        }
    </style>
</head>
<body>

<% for (Contact contact : contacts) { %>
<div class="contact">
    <div class="text">
        <div class="id"><%=contact.getId()%>
        </div>
        <div class="name"><%=contact.getName()%>
        </div>
        <div class="phone"><%=contact.getNumber()%>
        </div>

        <form action="/contactbookspring/delete" method="post">
            <input type="hidden" name="id" value="<%=contact.getId()%>">
            <input type="submit" value="delete">
        </form>
    </div>
</div>
<% } %>
<div class="communicator">
    <div class="cell">
        <h3>Добавить :</h3>
        <form action="/contactbookspring/add" method="post">
            <dl>
                <dt>Name :</dt>
                <dd><input type="text" name="name"></dd>
                <dt>Phone :</dt>
                <dd><input type="text" name="phone"></dd>
                <dd><input type="submit"></dd>
            </dl>
        </form>
    </div>

    <div class="cell">
        <h3>Поиск по имени :</h3>
        <form action="/contactbookspring/findName" method="post">
            <dl>
                <dt>Name :</dt>
                <dd><input type="text" name="name"></dd>
                <dd><input type="submit"></dd>
            </dl>
        </form>
    </div>

    <div class="cell">
        <h3>Поиск по номеру :</h3>
        <form action="/contactbookspring/findNumber" method="post">
            <dl>
                <dt>Number :</dt>
                <dd><input type="text" name="numberPart"></dd>
                <dd><input type="submit"></dd>
            </dl>
        </form>
    </div>

</div>
</body>
</html>
