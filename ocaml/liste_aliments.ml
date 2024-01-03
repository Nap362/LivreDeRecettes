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


(*----------type aliment----------*)

type aliment = Aliment of (string*float*unite)

let get_nom al = match al with Aliment(nom,_,_) -> nom

let get_quantite al = match al with Aliment(_, quant, _) -> quant

let get_unite al = match al with Aliment(_, _, unite) -> unite

let remplir al qt = Aliment((get_nom al), ((get_quantite al) +. qt),(get_unite al))

let utiliser al qt = if (get_quantite al) < qt then failwith "Quantité insuffisante" else Aliment((get_nom al), ((get_quantite al) -. qt), (get_unite al))

let aliment_to_string al pers =
  let quant_pers = (get_quantite al) *. (Float.of_int pers)
     in let quant_to_string = if (Float.is_integer quant_pers) || (quant_pers>= 10.) then Printf.sprintf "%d" (Float.to_int quant_pers) else Printf.sprintf "%.1f" quant_pers
        in Printf.sprintf ("%s : %s %s") (get_nom al) quant_to_string (unite_to_string (get_unite al))


(*----------opérations sur les listes d'aliments----------*)

let contient nom_al l = List.exists (fun x -> (get_nom x)=nom_al) l

let trouver nom_al l = List.find (fun x -> (get_nom x)=nom_al) l

let ajouter al l = if not (contient (get_nom al) l) then l@[al] else List.fold_right (fun e r -> if (get_nom e)=(get_nom al) then (remplir e (get_quantite al))::r else e::r) l []

let supprimer nom_al l = List.filter (fun x -> (get_nom x)!=nom_al) l

let quantite_suffisante al l = (contient (get_nom al) l) && ((get_quantite (trouver (get_nom al) l))>= (get_quantite al))

let contient_au_moins_un l re = List.exists (fun x -> contient (get_nom x) re) l

let recette_realisable re pla = List.for_all (fun x -> quantite_suffisante x pla) re

let liste_to_string l pers = List.fold_right (fun e r -> Printf.sprintf " - %s\n%s" (aliment_to_string e pers) r) l ""


(*----------tests----------*)
(*
let oeuf = Aliment("oeuf",1.,Sans)
let oeuf_string  = aliment_to_string oeuf 3

let farine = Aliment("farine", 100.4, G)
let farine_string = aliment_to_string farine 4
let oeuf2 = Aliment ("oeuf", 2., Sans)
let sucre = Aliment ("sucre", 0., G)
let beurre = Aliment ("beurre", 100., G)

let liste = ajouter oeuf2 (ajouter farine (ajouter oeuf creer_liste))

let liste_string = liste_to_string liste 3

let affichage = Printf.printf "%s" liste_string

let test = trouver "u" liste

let quant = quantite_suffisante sucre liste
*)
