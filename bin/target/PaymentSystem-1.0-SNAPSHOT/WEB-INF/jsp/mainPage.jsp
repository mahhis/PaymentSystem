<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>

<h1>Your Cards</h1>
<%--
<table border="1px">

    <c:forEach var="card" items="${sessionScope.cards}">
        <tr>
            <td><c:out value="${card.cardNumber}"/></td>
            <td><c:out value="${card.cardValidityDate}"/></td>
            <td><c:out value="${card.bankName}"/></td>
            <td><c:out value="${card.countryName}"/></td>
        </tr>
    </c:forEach>
</table>


<div class="container">
    <p>Add card</p>

    <form action="Controller" method ="post">

        <input type="hidden" name="command" value="AddCard">
        Card Number
        <input name="numberCard" type="tel" inputmode="number" pattern="[0-9\s]{13,19}" autocomplete="cc-number" maxlength="19" placeholder="xxxx xxxx xxxx xxxx"><br><br>
        Card Validity Date
        <input type="date" name="cardValidityDate" placeholder="Enter date card sender" class="form-control"><br>
        CVV
        <input type="number" name="CVV" placeholder="Enter cvv number card sender" class="form-control" pattern="^[0-9]{3, 4}$"><br>
        <br/>
        <input type="submit" value="Press me" />
    </form>

</div>--%>

<form action="Controller" method ="post">

    <input type="hidden" name="command" value="Transaction"><br>


    Sender Card Number
    <input name="numberCardSender" type="tel" inputmode="number"  maxlength="19" placeholder="xxxx xxxx xxxx xxxx"><br><br>

    <input type="date" name="cardValidityDate" placeholder="Enter date card sender" class="form-control"><br>

    <input type="number" name="CVV" placeholder="Enter cvv number card sender" class="form-control" pattern="^[0-9]{3, 4}$"><br>

    <input type="number" name="sum" placeholder="Enter sum" class="form-control"><br>

    <select name="bankNameSender">
        <option name="bankNameSender" value="AlfaBank">AlfaBank</option>
        <option name="bankNameSender" value="SberBank" selected>SberBank</option>
        <option name="bankNameSender" value="VTB">VTB</option>
        <option name="bankNameSender" value="JPMorgan">JPMorgan</option>
        <option name="bankNameSender" value="CityGroupBank" >CityGroupBank</option>
        <option name="bankNameSender" value="BankOfAmericka">BankOfAmericka</option>
    </select><br><br>

    <select name="senderCountry">
        <option name="senderCountry" value="Belarus" selected>Belarus</option>
        <option name="senderCountry" value="USA">USA</option>
    </select><br><br>


    Getter Card Number
    <input name="numberCardGetter" type="tel" inputmode="number"  autocomplete="cc-number" maxlength="19" placeholder="xxxx xxxx xxxx xxxx"><br><br>

    <select name="bankNameGetter">
        <option name="bankNameGetter" value="AlfaBank">AlfaBank</option>
        <option name="bankNameGetter" value="SberBank" selected>SberBank</option>
        <option name="bankNameGetter" value="VTB">VTB</option>
        <option name="bankNameGetter" value="JPMorgan">JPMorgan</option>
        <option name="bankNameGetter" value="CityGroupBank" >CityGroupBank</option>
        <option name="bankNameGetter" value="BankOfAmericka">BankOfAmericka</option>
    </select><br><br>

    <select name="getterCountry">
        <option name="getterCountry" value="Belarus" selected>Belarus</option>
        <option name="getterCountry" value="USA">USA</option>
    </select><br><br>


    <input type="submit" value="Press me" />
</form>

</body>
</html>
