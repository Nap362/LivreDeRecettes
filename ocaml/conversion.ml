open Liste_aliments

(* Prend une chaine de caractères en paramètre et renvoie une liste d'aliments *)
(* Ex : "lait,30.,CL;oeuf,2.,SANS;farine,150.,G" -> ["lait,30.,CL", "oeuf,2.,SANS", "farine,150.,G"]*)

let string_to_liste st = String.split_on_char ';' st

(* Prend une chaine de caractères en paramètre et renvoie un aliment *)
(* Ex : "lait,30.,CL" -> Aliment("lait", 30., Unite(CL)) *)

let alim_of_string st = let al_st = String.split_on_char ',' st
	in match al_st with 
		nom::quant::uni::[] -> Aliment(nom, (Float.of_string quant), (unite_of_string uni))
		| _ -> failwith "Erreur conversion aliment"

(* Prend une chaine de caractères en paramètre et renvoie une liste d'aliments *)
(* Ex : "lait,30.,CL;oeuf,2.,SANS;farine,150.,G" -> [Aliment("lait", 30., Unite(CL)), Aliment("oeuf", 2., Unite(SANS))] *)

let liste_alim_of_string st = let l_st = string_to_liste st in List.fold_right (fun e r -> (alim_of_string e)::r) l_st []

let string_of_unite u = match u with
  | MG -> "MG"
  | G -> "G"
  | ML -> "ML"
  | CL -> "CL"
  | L -> "L"
  | SANS -> "SANS"
  | CAS -> "CAS"
  | CAC -> "CAC"
  | SACHET -> "SACHET"
  | PINCEE -> "PINCEE"

let string_of_alim alim = match alim with 
	Aliment(nom, quant, unite) -> Printf.sprintf ("%s,%s,%s") nom (Float.to_string quant) (string_of_unite unite)

let string_of_liste_alim liste = let st = List.fold_right (fun e r -> Printf.sprintf "%s;%s" (string_of_alim e) r) liste "" in 
	String.sub st 0 ((String.length st) - 2)
