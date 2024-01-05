(*----------type unite----------*)

type unite = MG | G | ML | CL | L | SANS | CAS | CAC | SACHET | PINCEE

let unite_to_string u = match u with
  | MG -> "mg"
  | G -> "g"
  | ML -> "mL"
  | CL -> "cL"
  | L -> "L"
  | SANS -> ""
  | CAS -> "cuillère(s) à soupe"
  | CAC -> "cuillère(s) à café"
  | SACHET -> "sachet(s)"
  | PINCEE -> "pincée(s)"

let unite_of_string s = match s with
  | "MG" -> MG
  | "G" -> G
  | "ML" -> ML
  | "CL" -> CL
  | "L" -> L
  | "SANS" -> SANS
  | "CAS" -> CAS
  | "CAC" -> CAC
  | "SACHET" -> SACHET
  | "PINCEE" -> PINCEE
  | _ -> failwith "Unite inconnue"


(*----------type aliment----------*)

type aliment = Aliment of (string*float*unite)

let get_nom al = match al with Aliment(nom,_,_) -> nom

let get_quantite al = match al with Aliment(_, quant, _) -> quant

let get_unite al = match al with Aliment(_, _, unite) -> unite

let remplir al qt = Aliment((get_nom al), ((get_quantite al) +. qt),(get_unite al))

let utiliser al qt = if (get_quantite al) < qt then failwith "Quantite insuffisante" else Aliment((get_nom al), ((get_quantite al) -. qt), (get_unite al))

let convert_unite alim = let quant = (get_quantite alim) in
	match (get_unite alim) with 
	  | MG -> if quant > 1000. then Aliment((get_nom alim), (quant /. 1000.), G) else alim
	  | G -> if quant < 1. then Aliment((get_nom alim), (quant *. 1000.), MG) else alim
	  | ML -> if quant > 10. then Aliment((get_nom alim), (quant /. 10.), CL) else alim
	  | CL -> if quant < 1. then Aliment((get_nom alim), (quant *. 10.), ML) else alim
	  | L -> if quant < 1. then Aliment((get_nom alim), (quant *. 100.), CL) else if quant > 100. then Aliment((get_nom alim), (quant /. 100.), L) else alim
	  | CAC -> if quant < 3. then Aliment((get_nom alim), (quant /. 3.), CAC) else alim
	  | CAS -> if quant < 1. then Aliment((get_nom alim), (quant *. 3.), CAC) else alim
	  | _ -> alim

let quant_to_string quant = if (Float.is_integer quant) || (quant>= 10.) then Printf.sprintf "%d" (Float.to_int quant) else Printf.sprintf "%f" quant

let aliment_to_string al pers =
   let alim = remplir al ((get_quantite al) *. (pers -. 1.)) in 
    let alim_conv = convert_unite alim in
     Printf.sprintf "%s : %s %s" (get_nom alim_conv) (quant_to_string (get_quantite alim_conv)) (unite_to_string (get_unite alim_conv))


(*----------opérations sur les listes d aliments----------*)

let contient nom_al l = List.exists (fun x -> (get_nom x)=nom_al) l

let trouver nom_al l = List.find (fun x -> (get_nom x)=nom_al) l

let ajouter al l = if not (contient (get_nom al) l) then l@[al] else List.fold_right (fun e r -> if (get_nom e)=(get_nom al) then (remplir e (get_quantite al))::r else e::r) l []

let supprimer nom_al l = List.filter (fun x -> (get_nom x)<>nom_al) l

let remplacer ancAlim nouvAlim l = let l_temp = supprimer (get_nom ancAlim) l in ajouter nouvAlim l_temp

let modif_nom ancNom nouvNom l = let ancAlim = trouver ancNom l in
                                 let nouvAlim = Aliment(nouvNom, (get_quantite ancAlim),(get_unite ancAlim)) in
                                 remplacer ancAlim nouvAlim l

let modif_quant nom quant l = let ancAlim = trouver nom l in
                                 let nouvAlim = Aliment(nom, quant,(get_unite ancAlim)) in
                                 remplacer ancAlim nouvAlim l

let quantite_suffisante al pers l = (contient (get_nom al) l) && ((get_quantite (trouver (get_nom al) l)) >= ((get_quantite al)*. pers))

let contient_au_moins_un l re = List.exists (fun x -> contient (get_nom x) re) l

let recette_realisable re pla pers = List.for_all (fun x -> quantite_suffisante x pers pla) re

let faire_recette re pla pers = let utiliser_dans_liste al l =
                             let ancAlim = trouver (get_nom al) l in
                             let nouvAlim = utiliser ancAlim ((get_quantite al) *. pers) in
                           remplacer ancAlim nouvAlim l in
                           List.fold_left (fun r e -> utiliser_dans_liste e r) pla re

let faire_course cou pla = List.fold_left (fun r e -> ajouter e r) pla cou


let liste_to_string l pers = List.fold_right (fun e r -> (Printf.sprintf " - %s\n%s" (aliment_to_string e pers) r)) l ""



(*----------tests----------*)



