<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Item" %>

<html>
<head>
    <title>Invoice</title>
</head>
<body>
    <h2>Invoice Details</h2>

<%
    List<Item> selectedItems = (List<Item>) session.getAttribute("selectedItems");
    if (selectedItems != null && !selectedItems.isEmpty()) {
        double total = 0;
%>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>Item Description</th>
            <th>Price (Rs)</th>
        </tr>
        <% for (Item item : selectedItems) {
            total += item.getItemPrice();
        %>
        <tr>
            <td><%= item.getItemDesc() %></td>
            <td><%= item.getItemPrice() %></td>
        </tr>
        <% } %>
        <tr>
            <td><strong>Total</strong></td>
            <td><strong><%= total %></strong></td>
        </tr>
    </table>
<%
    } else {
%>
    <p>No items selected.</p>
<%
    }
%>

</body>
</html>