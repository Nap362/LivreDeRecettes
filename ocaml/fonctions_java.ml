open Liste_aliments
open Conversion

(*On recupère les arguments en enlevant le premier qui est le nom du programme puis on sépare le premier argument des autres car le premier argument permettra de définir quelle fonction appeler*)
let get_args () = let args = List.tl (Array.to_list Sys.argv) in (List.hd args, List.tl args)
		
(*aff liste pers*)
let fct_afficher_liste liste pers = liste_to_string (liste_alim_of_string liste) (Float.of_string pers)

(*ajt liste alim*)
let fct_ajouter_aliment liste alim = string_of_liste_alim(ajouter (alim_of_string alim) (liste_alim_of_string liste))
	

(*modn liste ancNom nouvNom*)
let fct_modifier_nom liste ancNom nouvNom = string_of_liste_alim(modif_nom ancNom nouvNom (liste_alim_of_string liste))
	

(*modq liste nom nouvQuant*)
let fct_modifier_quant liste nom nouvQuant = string_of_liste_alim(modif_quant nom (Float.of_string nouvQuant) (liste_alim_of_string liste))
	

(*supp liste nom*)
let fct_supprimer_alim liste nom = string_of_liste_alim(supprimer nom (liste_alim_of_string liste))

(*recrea recette placard pers*)
let fct_recette_realisbale rece plac pers = if recette_realisable (liste_alim_of_string rece) (liste_alim_of_string plac) (Float.of_string pers) then "Réalisable" else "Ingrédient(s) manquant(s)"

(*reccon recette liste*)
let fct_recette_contient rece liste = if contient_au_moins_un (liste_alim_of_string liste) (liste_alim_of_string rece) then "Contient au moins un ingrédient" else "Ne contient aucun de ces ingrédients"

(*fairec recette placard pers*)
let fct_faire_recette rece plac pers = string_of_liste_alim(faire_recette (liste_alim_of_string rece) (liste_alim_of_string plac) (Float.of_string pers))

(*faicou liste_course placard*)
let fct_faire_course cou plac = string_of_liste_alim(faire_course (liste_alim_of_string cou) (liste_alim_of_string plac))


let main () = let (fonc, args) = get_args () in let () = Printf.printf "%s %d\n" fonc (List.length args) in
	match (fonc, List.length args) with
		 "aff", 2 ->  fct_afficher_liste (List.nth args 0) (List.nth args 1)
		|"ajt", 2 -> fct_ajouter_aliment (List.nth args 0) (List.nth args 1)
		|"modn", 3  -> fct_modifier_nom (List.nth args 0) (List.nth args 1) (List.nth args 2)
		|"modq", 3 -> fct_modifier_quant (List.nth args 0) (List.nth args 1) (List.nth args 2)
		|"supp", 2 -> fct_supprimer_alim (List.nth args 0) (List.nth args 1)
		|"recrea", 3 -> fct_recette_realisbale (List.nth args 0) (List.nth args 1) (List.nth args 2)
		|"reccon", 2 -> fct_recette_contient (List.nth args 0) (List.nth args 1)
		|"fairec", 3 -> fct_faire_recette (List.nth args 0) (List.nth args 1) (List.nth args 2)
		|"faicou", 2 -> fct_faire_course (List.nth args 0) (List.nth args 1)
		|_ -> failwith "Commande inconnue"

let _ = main ()
