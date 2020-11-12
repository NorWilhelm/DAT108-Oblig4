<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<!-- Fra https://purecss.io/ -->
	<link rel="stylesheet"href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
	<link href="css/formcontroller.css" rel="stylesheet" type="text/css" />
	<script src="js/formcontroller.js" defer></script>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	
	<title>Påmelding</title>
	</head>
	<body>
		<h2>Påmelding</h2>
		<div id="root">
			<form method="post" class="pure-form pure-form-aligned">
				<fieldset>
					<div class="pure-control-group">
						<label for="fornavn">Fornavn:</label> <input id="fornavn"
							type="text" name="fornavn" value="${Skjema.fornavn}" required/> <font id="feilFornavn"
							color="red">${Skjema.fornavnFeil}</font>
					</div>
					<div class="pure-control-group">
						<label for="etternavn">Etternavn:</label> <input id="etternavn"
							type="text" name="etternavn" value="${Skjema.etternavn}" required/> <font id="feilEtternavn"
							color="red">${Skjema.etternavnFeil}</font>
					</div>
					<div class="pure-control-group">
						<label for="mobil">Mobil (8 siffer):</label> <input id="mobil"
							type="text" name="mobil" value="${Skjema.mobil}" required/> <font id="feilMobil"
							color="red">${Skjema.mobilFeil}</font>
					</div>
				
					<div class="pure-control-group">
						<label for="passord">Passord:
						<div id="passord_info" data-info="passord"></div>
						</label><input type="password"
							name="passord" id="passord" value="${Skjema.passord}" required/> 
							<font color="red" >${Skjema.passordFeil}</font>
					</div>
					<div class="pure-control-group">
						<label for="passordRepetert">Passord repetert:</label> <input
							id="passordRepetert" type="password" name="passordRepetert"
							value="" required/> <font id="feilPassordRepetert" color="red">${Skjema.passordRepFeil}</font>
					</div>
					<div class="pure-control-group">
						<label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn"
							value="mann" ${Skjema.mann} />mann <input type="radio"
							name="kjonn" value="kvinne" ${Skjema.kvinne} required/>kvinne <font
							color="red">${Skjema.kjonnFeil}</font>
					</div>
					<div class="pure-controls">
						<button type="submit" class="pure-button pure-button-primary">Meld
							meg på</button>
							<div data-info="submit"></div>
					</div>
					
					
		
		
				</fieldset>
			</form>
		</div>
	</body>
</html>