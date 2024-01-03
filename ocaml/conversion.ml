open Liste_aliments

(* Prend une chaine de caractères en paramètre et renvoie une liste d'aliments *)
(* Ex : "lait,30.,CL;oeuf,2.,SANS;farine,150.,G" -> ["lait,30.,CL", "oeuf,2.,SANS", "farine,150.,G"]*)

let list_ch = String.split_on_char ';' Sys.argv

(* Prend une chaine de caractères en paramètre et un aliment *)
(* Ex : "lait,30.,CL" -> Aliment("lait", 30., Unite(CL)) *)

let conv_al ch = let al_ch = String.split_on_char "," ch 
	in match al_ch with 
		nom::quant::uni -> Aliment(nom, (Float.of_string quant), (unite_of_string uni))
		| _ -> failwith "Erreur conversion aliment"

let liste_aliment = List.fold_right (fun e r -> (conv_al e)