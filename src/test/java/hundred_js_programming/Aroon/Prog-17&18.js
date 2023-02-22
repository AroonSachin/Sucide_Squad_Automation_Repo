/**
 * @Question Prlet Star console
 */

function PrintStar(x, y) {
	let str = "";
	// Upper part.
	for (i = 1; i <= y / 4; i++) {
		for (j = 1; j <= x; j++) {
			if (j < (x - i)) {
				str = str.concat(" ")
			} else
				if (j > (x - i)) {
					str = str.concat(" *")
				}
		}
		console.log(str)
		str = ""
	}
	
	//Lower Upper part.
	for (i = 1; i <= y / 4; i++) {
		for (j = 1; j <= x; j++) {
			if (j < (x - (16-i))) {
				str = str.concat(" ")
			} else if (j > (x - (16-i))) {
					str = str.concat(" *")
				}
		}
		console.log(str)
		str = ""
	}

}
PrintStar(60, 60);
