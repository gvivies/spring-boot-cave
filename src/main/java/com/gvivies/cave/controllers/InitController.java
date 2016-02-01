package com.gvivies.cave.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gvivies.cave.model.Dealer;
import com.gvivies.cave.model.Region;
import com.gvivies.cave.model.Wine;
import com.gvivies.cave.repositories.DealerRepository;
import com.gvivies.cave.repositories.RegionRepository;
import com.gvivies.cave.repositories.WineRepository;

@RestController
@RequestMapping("/initcave")
public class InitController {

	private final static String UNKNOWN = "Non connu";
	
	@Autowired
	private WineRepository repositoryWine;

	@Autowired
	private RegionRepository repositoryRegion;

	@Autowired
	private DealerRepository repositoryDealer;

	@RequestMapping(method=RequestMethod.GET)
	private void initForUser(String owner) {

		if (repositoryDealer.findByName(UNKNOWN) != null) {
			return;
		}
		
		initDealer();
		initRegions();

		Region bordeaux = repositoryRegion.findByName("Bordeaux");
		initAppellationsBordeaux(bordeaux);

		Region alsace = repositoryRegion.findByName("Alsace");
		initAppellationsAlsace(alsace);

		Region bourgogne = repositoryRegion.findByName("Bourgogne");
		initAppellationsBourgogne(bourgogne);

		Region sudouest = repositoryRegion.findByName("Sud-Ouest");
		initAppellationsSudOuest(sudouest);

		Region loire = repositoryRegion.findByName("Loire");
		initAppellationsLoire(loire);

		Region champagne = repositoryRegion.findByName("Champagne");
		initAppellationsChampagne(champagne);

		Region cotesdurhone = repositoryRegion.findByName("Côtes du Rhône");
		initAppellationsCotesDuRhone(cotesdurhone);

		Region corse = repositoryRegion.findByName("Corse");
		initAppellationsCorse(corse);

		Region provence = repositoryRegion.findByName("Provence");
		initAppellationsProvence(provence);

		Region languedoc = repositoryRegion.findByName("Languedoc-Roussillon");
		initAppellationsLanguedoc(languedoc);
	}

	private void initAppellationsLanguedoc(Region languedoc) {
		repositoryWine.insert(new Wine("Côtes-Catalanes", languedoc));
		repositoryWine.insert(new Wine("Côte-Vermeille", languedoc));
		repositoryWine.insert(new Wine("Pyrénées-Orientales", languedoc));
		repositoryWine.insert(new Wine("Collioure", languedoc));
		repositoryWine.insert(new Wine("Côtes-du-Roussillon", languedoc));
		repositoryWine.insert(new Wine("Côtes-du-Roussillon Les Aspres", languedoc));
		repositoryWine.insert(new Wine("Côtes-du-Roussillon Villages", languedoc));
		repositoryWine.insert(new Wine("Caramany", languedoc));
		repositoryWine.insert(new Wine("Lesquerde", languedoc));
		repositoryWine.insert(new Wine("Tautavel", languedoc));
		repositoryWine.insert(new Wine("Latour-de-France", languedoc));
		repositoryWine.insert(new Wine("Banyuls", languedoc));
		repositoryWine.insert(new Wine("Banyuls Grand Cru", languedoc));
		repositoryWine.insert(new Wine("Grand Roussillon", languedoc));
		repositoryWine.insert(new Wine("Maury", languedoc));
		repositoryWine.insert(new Wine("Muscat de Rivesaltes", languedoc));
		repositoryWine.insert(new Wine("Rivesaltes", languedoc));
		repositoryWine.insert(new Wine("Cabrières", languedoc));
		repositoryWine.insert(new Wine("Clairette du Languedoc", languedoc));
		repositoryWine.insert(new Wine("Faugères", languedoc));
		repositoryWine.insert(new Wine("Grès-de-Montpellier", languedoc));
		repositoryWine.insert(new Wine("La Clape", languedoc));
		repositoryWine.insert(new Wine("La Méjanelle", languedoc));
		repositoryWine.insert(new Wine("Montpeyroux", languedoc));
		repositoryWine.insert(new Wine("Pézenas", languedoc));
		repositoryWine.insert(new Wine("Picpoul de Pinet", languedoc));
		repositoryWine.insert(new Wine("Pic-Saint-Loup", languedoc));
		repositoryWine.insert(new Wine("Quatourze", languedoc));
		repositoryWine.insert(new Wine("Saint-Chinian", languedoc));
		repositoryWine.insert(new Wine("Saint-Christol", languedoc));
		repositoryWine.insert(new Wine("Saint-Drézéry", languedoc));
		repositoryWine.insert(new Wine("Saint-Georges-d\'orques", languedoc));
		repositoryWine.insert(new Wine("Saint-Saturnin", languedoc));
		repositoryWine.insert(new Wine("Terrasses-du-Larzac", languedoc));
		repositoryWine.insert(new Wine("Sommières", languedoc));
		repositoryWine.insert(new Wine("Vérargues", languedoc));
		repositoryWine.insert(new Wine("Blanquette de Limoux", languedoc));
		repositoryWine.insert(new Wine("Crémant de Limoux", languedoc));
		repositoryWine.insert(new Wine("Limoux", languedoc));
		repositoryWine.insert(new Wine("Cabardès", languedoc));
		repositoryWine.insert(new Wine("Corbières", languedoc));
		repositoryWine.insert(new Wine("Corbières-Boutenac", languedoc));
		repositoryWine.insert(new Wine("Languedoc", languedoc));
		repositoryWine.insert(new Wine("Fitou", languedoc));
		repositoryWine.insert(new Wine("Minervois", languedoc));
		repositoryWine.insert(new Wine("Minervois-la-Livinière", languedoc));
		repositoryWine.insert(new Wine("Malepère", languedoc));
		repositoryWine.insert(new Wine("Muscat de Frontignan", languedoc));
		repositoryWine.insert(new Wine("Muscat de Mireval", languedoc));
		repositoryWine.insert(new Wine("Muscat de Saint-Jean-de-Minervois", languedoc));
		repositoryWine.insert(new Wine("Muscat de Lune", languedoc));
	}

	private void initAppellationsChampagne(Region champagne) {
		repositoryWine.insert(new Wine("Champagne", champagne));
		repositoryWine.insert(new Wine("Coteaux champenois", champagne));
		repositoryWine.insert(new Wine("Rosé des Riceys", champagne));
	}

	private void initRegions() {
		repositoryRegion.insert(new Region("Bordeaux"));
		repositoryRegion.insert(new Region("Bourgogne"));
		repositoryRegion.insert(new Region("Sud-Ouest"));
		repositoryRegion.insert(new Region("Loire"));
		repositoryRegion.insert(new Region("Alsace"));
		repositoryRegion.insert(new Region("Champagne"));
		repositoryRegion.insert(new Region("Côtes du Rhône"));
		repositoryRegion.insert(new Region("Corse"));
		repositoryRegion.insert(new Region("Provence"));
		repositoryRegion.insert(new Region("Languedoc-Roussillon"));
	}

	private void initDealer() {
		repositoryDealer.insert(new Dealer(UNKNOWN, "", "", "", "", "", "", "", "", ""));
	}

	private void initAppellationsBordeaux(Region bordeaux) {
		repositoryWine.insert(new Wine("Médoc", bordeaux));
		repositoryWine.insert(new Wine("Haut-Médoc", bordeaux));
		repositoryWine.insert(new Wine("Saint-Estèphe", bordeaux));
		repositoryWine.insert(new Wine("Pauillac", bordeaux));
		repositoryWine.insert(new Wine("Saint-Julien", bordeaux));
		repositoryWine.insert(new Wine("Listrac-Médoc", bordeaux));
		repositoryWine.insert(new Wine("Moulis-en-Médoc", bordeaux));
		repositoryWine.insert(new Wine("Margaux", bordeaux));
		repositoryWine.insert(new Wine("Pessac-Léognan", bordeaux));
		repositoryWine.insert(new Wine("Graves-Supérieurs", bordeaux));
		repositoryWine.insert(new Wine("Graves", bordeaux));
		repositoryWine.insert(new Wine("Cérons", bordeaux));
		repositoryWine.insert(new Wine("Barsac", bordeaux));
		repositoryWine.insert(new Wine("Sauternes", bordeaux));
		repositoryWine.insert(new Wine("Entre-deux-mers", bordeaux));
		repositoryWine.insert(new Wine("Graves-de-vayres", bordeaux));
		repositoryWine.insert(new Wine("Premières-côtes-de-Bordeaux", bordeaux));
		repositoryWine.insert(new Wine("Cadillac", bordeaux));
		repositoryWine.insert(new Wine("Cadillac-côtes-de-Bordeaux", bordeaux));
		repositoryWine.insert(new Wine("Loupiac", bordeaux));
		repositoryWine.insert(new Wine("Sainte-Croix-du-Mont", bordeaux));
		repositoryWine.insert(new Wine("Bordeaux-Haut-Benauge", bordeaux));
		repositoryWine.insert(new Wine("Côtes-de-Bordeaux-Saint-Macaire", bordeaux));
		repositoryWine.insert(new Wine("Sainte-Foy-Bordeaux", bordeaux));
		repositoryWine.insert(new Wine("Fronsac", bordeaux));
		repositoryWine.insert(new Wine("Canon-Fronsac", bordeaux));
		repositoryWine.insert(new Wine("Pomerol", bordeaux));
		repositoryWine.insert(new Wine("Lalande-de-Pomerol", bordeaux));
		repositoryWine.insert(new Wine("Néac", bordeaux));
		repositoryWine.insert(new Wine("Saint-Emilion", bordeaux));
		repositoryWine.insert(new Wine("Montagne-Saint-Emilion", bordeaux));
		repositoryWine.insert(new Wine("Saint-georges-Saint-Emilion", bordeaux));
		repositoryWine.insert(new Wine("Lussac-Saint-Emilion", bordeaux));
		repositoryWine.insert(new Wine("Puisseguin-Saint-Emilion", bordeaux));
		repositoryWine.insert(new Wine("Francs-côtes-de-Bordeaux", bordeaux));
		repositoryWine.insert(new Wine("Castillon-côtes-de-Bordeaux", bordeaux));
		repositoryWine.insert(new Wine("Blaye", bordeaux));
		repositoryWine.insert(new Wine("Côtes-de-Blaye", bordeaux));
		repositoryWine.insert(new Wine("Blaye-côtes-de-Bordeaux", bordeaux));
		repositoryWine.insert(new Wine("Côtes-de-Bourg", bordeaux));
	}

	private void initAppellationsAlsace(Region alsace) {
		repositoryWine.insert(new Wine("Riesling", alsace));
		repositoryWine.insert(new Wine("Pinot-gris", alsace));
		repositoryWine.insert(new Wine("Gewurztraminer", alsace));
		repositoryWine.insert(new Wine("Muscat", alsace));
		repositoryWine.insert(new Wine("Pinot-noir", alsace));
		repositoryWine.insert(new Wine("Sylvaner", alsace));
		repositoryWine.insert(new Wine("Klevener de Heiligenstein", alsace));
		repositoryWine.insert(new Wine("Pinot", alsace));
		repositoryWine.insert(new Wine("Chasselas", alsace));
		repositoryWine.insert(new Wine("Edelzwicker", alsace));
	}

	private void initAppellationsBourgogne(Region bourgogne) {
		repositoryWine.insert(new Wine("Petit-chablis", bourgogne));
		repositoryWine.insert(new Wine("Chablis", bourgogne));
		repositoryWine.insert(new Wine("Chablis Grand Cru", bourgogne));
		repositoryWine.insert(new Wine("Irancy", bourgogne));
		repositoryWine.insert(new Wine("Saint-Bris", bourgogne));
		repositoryWine.insert(new Wine("Côte-d’Auxerre", bourgogne));
		repositoryWine.insert(new Wine("Chitry", bourgogne));
		repositoryWine.insert(new Wine("Coulanges-La-Vineuse", bourgogne));
		repositoryWine.insert(new Wine("Tonnerre", bourgogne));
		repositoryWine.insert(new Wine("Epineuil", bourgogne));
		repositoryWine.insert(new Wine("Vézelay", bourgogne));
		repositoryWine.insert(new Wine("Côte-Saint-Jacques", bourgogne));
		repositoryWine.insert(new Wine("Montrecul", bourgogne));
		repositoryWine.insert(new Wine("Le-Chapitre", bourgogne));
		repositoryWine.insert(new Wine("Fixin", bourgogne));
		repositoryWine.insert(new Wine("Marsannay", bourgogne));
		repositoryWine.insert(new Wine("Gevrey-Chambertin", bourgogne));
		repositoryWine.insert(new Wine("Chambertin", bourgogne));
		repositoryWine.insert(new Wine("Chambertin-Clos-de-Bèze", bourgogne));
		repositoryWine.insert(new Wine("Chapelle-Chambertin", bourgogne));
		repositoryWine.insert(new Wine("Charmes-Chambertin", bourgogne));
		repositoryWine.insert(new Wine("Mazis-Chambertin", bourgogne));
		repositoryWine.insert(new Wine("Griotte-Chambertin", bourgogne));
		repositoryWine.insert(new Wine("Latricières-Chambertin", bourgogne));
		repositoryWine.insert(new Wine("Ruchottes-Chambertin", bourgogne));
		repositoryWine.insert(new Wine("Mazoyères-Chambertin", bourgogne));
		repositoryWine.insert(new Wine("Morey-Saint-Denis", bourgogne));
		repositoryWine.insert(new Wine("Clos-de-Tart", bourgogne));
		repositoryWine.insert(new Wine("Clos-Saint-Denis", bourgogne));
		repositoryWine.insert(new Wine("Clos-de-la-Roche", bourgogne));
		repositoryWine.insert(new Wine("Clos-des-Lambrays", bourgogne));
		repositoryWine.insert(new Wine("Chambolle-Musigny", bourgogne));
		repositoryWine.insert(new Wine("Musigny", bourgogne));
		repositoryWine.insert(new Wine("Bonnes-Mares", bourgogne));
		repositoryWine.insert(new Wine("Vougeot", bourgogne));
		repositoryWine.insert(new Wine("Clos-Vougeot", bourgogne));
		repositoryWine.insert(new Wine("Echezeaux", bourgogne));
		repositoryWine.insert(new Wine("Grands-Echezeaux", bourgogne));
		repositoryWine.insert(new Wine("Vosne-Romanée", bourgogne));
		repositoryWine.insert(new Wine("Romanée-Conti", bourgogne));
		repositoryWine.insert(new Wine("Richebourg", bourgogne));
		repositoryWine.insert(new Wine("La-Romanée", bourgogne));
		repositoryWine.insert(new Wine("La-Tâche", bourgogne));
		repositoryWine.insert(new Wine("Romanée-Saint-Vivant", bourgogne));
		repositoryWine.insert(new Wine("La-Grande-Rue", bourgogne));
		repositoryWine.insert(new Wine("Nuits-Saint-Georges", bourgogne));
		repositoryWine.insert(new Wine("Côte-de-Nuits-Villages", bourgogne));
		repositoryWine.insert(new Wine("Hautes-Côtes-de-Nuits", bourgogne));
		repositoryWine.insert(new Wine("Ladoix", bourgogne));
		repositoryWine.insert(new Wine("La-Chapelle-Notre-Dame", bourgogne));
		repositoryWine.insert(new Wine("Aloxe-Corton", bourgogne));
		repositoryWine.insert(new Wine("Corton", bourgogne));
		repositoryWine.insert(new Wine("Corton-Charlemagne", bourgogne));
		repositoryWine.insert(new Wine("Charlemagne", bourgogne));
		repositoryWine.insert(new Wine("Chorey-Lès-Beaune", bourgogne));
		repositoryWine.insert(new Wine("Savigny-Lès-Beaune", bourgogne));
		repositoryWine.insert(new Wine("Pernand-Vergelesses", bourgogne));
		repositoryWine.insert(new Wine("Beaune", bourgogne));
		repositoryWine.insert(new Wine("Côte-de-Beaune", bourgogne));
		repositoryWine.insert(new Wine("Pommard", bourgogne));
		repositoryWine.insert(new Wine("Volnay", bourgogne));
		repositoryWine.insert(new Wine("Meursault", bourgogne));
		repositoryWine.insert(new Wine("Auxey-Duresses", bourgogne));
		repositoryWine.insert(new Wine("Monthélie", bourgogne));
		repositoryWine.insert(new Wine("Puligny-Montrachet", bourgogne));
		repositoryWine.insert(new Wine("Chevalier-Montrachet", bourgogne));
		repositoryWine.insert(new Wine("Bienvenues-Bâtard-Montrachet", bourgogne));
		repositoryWine.insert(new Wine("Montrachet", bourgogne));
		repositoryWine.insert(new Wine("Bâtard-Montrachet", bourgogne));
		repositoryWine.insert(new Wine("Chassagne-Montrachet", bourgogne));
		repositoryWine.insert(new Wine("Criots-Bâtard-Montrachet", bourgogne));
		repositoryWine.insert(new Wine("Saint-Aubin", bourgogne));
		repositoryWine.insert(new Wine("Saint-Romain", bourgogne));
		repositoryWine.insert(new Wine("Blagny", bourgogne));
		repositoryWine.insert(new Wine("Santenay", bourgogne));
		repositoryWine.insert(new Wine("Maranges", bourgogne));
		repositoryWine.insert(new Wine("Côte-de-Beaune-Villages", bourgogne));
		repositoryWine.insert(new Wine("Hautes-Côtes-de-Beaune", bourgogne));
		repositoryWine.insert(new Wine("Bouzeron", bourgogne));
		repositoryWine.insert(new Wine("Rully", bourgogne));
		repositoryWine.insert(new Wine("Mercurey", bourgogne));
		repositoryWine.insert(new Wine("Givry", bourgogne));
		repositoryWine.insert(new Wine("Montagny", bourgogne));
		repositoryWine.insert(new Wine("Côte-Chalonnaise", bourgogne));
		repositoryWine.insert(new Wine("Côtes-du-Couchois", bourgogne));
		repositoryWine.insert(new Wine("Pouilly-Fuissé", bourgogne));
		repositoryWine.insert(new Wine("Pouilly-Vinzelles", bourgogne));
		repositoryWine.insert(new Wine("Pouilly-Loché", bourgogne));
		repositoryWine.insert(new Wine("Saint-véran", bourgogne));
		repositoryWine.insert(new Wine("Viré-clessé", bourgogne));
		repositoryWine.insert(new Wine("Mâcon", bourgogne));
		repositoryWine.insert(new Wine("Mâcon-villages", bourgogne));
		repositoryWine.insert(new Wine("Bourgogne", bourgogne));
		repositoryWine.insert(new Wine("Bourgogne-aligoté", bourgogne));
		repositoryWine.insert(new Wine("Bourgogne-Passe-Tout-Grains", bourgogne));
		repositoryWine.insert(new Wine("Coteaux-Bourguignons", bourgogne));
		repositoryWine.insert(new Wine("Crémant de Bourgogne", bourgogne));
		repositoryWine.insert(new Wine("Bourgogne-Mousseux", bourgogne));
	}

	private void initAppellationsSudOuest(Region sudouest) {
		repositoryWine.insert(new Wine("Bergeracois Bergerac", sudouest ));
		repositoryWine.insert(new Wine("Côtes-de-Bergerac", sudouest ));
		repositoryWine.insert(new Wine("Montravel", sudouest ));
		repositoryWine.insert(new Wine("Haut-Montravel", sudouest ));
		repositoryWine.insert(new Wine("Côtes-de-Montravel", sudouest ));
		repositoryWine.insert(new Wine("Monbazillac", sudouest ));
		repositoryWine.insert(new Wine("Pécharmant", sudouest ));
		repositoryWine.insert(new Wine("Rosette", sudouest ));
		repositoryWine.insert(new Wine("Saussignac", sudouest ));
		repositoryWine.insert(new Wine("Périgord", sudouest ));
		repositoryWine.insert(new Wine("Côtes-du-Marmandais", sudouest ));
		repositoryWine.insert(new Wine("Côtes-de-duras", sudouest ));
		repositoryWine.insert(new Wine("Buzet", sudouest ));
		repositoryWine.insert(new Wine("Thézac-Perricard", sudouest ));
		repositoryWine.insert(new Wine("Côtes-du-brulhois", sudouest ));
		repositoryWine.insert(new Wine("Fronton", sudouest ));
		repositoryWine.insert(new Wine("Lavilledieu", sudouest ));
		repositoryWine.insert(new Wine("Agenais", sudouest ));
		repositoryWine.insert(new Wine("Coteaux-et-Terrasses-de-Montauban", sudouest ));
		repositoryWine.insert(new Wine("Cahors", sudouest ));
		repositoryWine.insert(new Wine("Coteaux-du-Quercy", sudouest ));
		repositoryWine.insert(new Wine("Coteaux-de-Glanes", sudouest ));
		repositoryWine.insert(new Wine("Entraygues-et-du-Fel", sudouest ));
		repositoryWine.insert(new Wine("Estaing", sudouest ));
		repositoryWine.insert(new Wine("Gaillac", sudouest ));
		repositoryWine.insert(new Wine("Gaillac-Premières-Côtes", sudouest ));
		repositoryWine.insert(new Wine("Côtes-du-Tarn", sudouest ));
		repositoryWine.insert(new Wine("Côtes-de-Millau", sudouest ));
		repositoryWine.insert(new Wine("Marcillac", sudouest ));
		repositoryWine.insert(new Wine("Armagnac", sudouest ));
		repositoryWine.insert(new Wine("Floc de Gascogne", sudouest ));
		repositoryWine.insert(new Wine("Côtes-de-Saint-Mont", sudouest ));
		repositoryWine.insert(new Wine("Madiran", sudouest ));
		repositoryWine.insert(new Wine("Pacherenc-du-Vic-Bilh", sudouest ));
		repositoryWine.insert(new Wine("Côtes-du-Condomois", sudouest ));
		repositoryWine.insert(new Wine("Côtes-de-Gascogne", sudouest ));
		repositoryWine.insert(new Wine("Côtes-de-Montestruc", sudouest ));
		repositoryWine.insert(new Wine("Béarn", sudouest ));
		repositoryWine.insert(new Wine("Tursan", sudouest ));
		repositoryWine.insert(new Wine("Jurançon", sudouest ));
		repositoryWine.insert(new Wine("Bigorre", sudouest ));
		repositoryWine.insert(new Wine("Coteaux-de-Chalosse", sudouest ));
		repositoryWine.insert(new Wine("Terroirs-landais", sudouest ));
		repositoryWine.insert(new Wine("Irouléguy", sudouest ));
	}

	private void initAppellationsLoire(Region loire) {
		repositoryWine.insert(new Wine("Crémant de Loire", loire ));
		repositoryWine.insert(new Wine("Rosé de Loire", loire ));
		repositoryWine.insert(new Wine("Val-de-loire	", loire ));
		repositoryWine.insert(new Wine("Gros-Plant-du-Pays-Nantais", loire ));
		repositoryWine.insert(new Wine("Muscadet", loire ));
		repositoryWine.insert(new Wine("Muscadet-Coteaux-de-la-Loire", loire ));
		repositoryWine.insert(new Wine("Coteaux-d\'Ancenis", loire ));
		repositoryWine.insert(new Wine("Muscadet-Sèvre-et-Maine", loire ));
		repositoryWine.insert(new Wine("Muscadet-Côtes-de-Grandlieu", loire ));
		repositoryWine.insert(new Wine("Fiefs-Vendéens", loire ));
		repositoryWine.insert(new Wine("Loire-Atlantique", loire ));
		repositoryWine.insert(new Wine("Vendée", loire ));
		repositoryWine.insert(new Wine("Anjou", loire ));
		repositoryWine.insert(new Wine("Cabernet d\'Anjou", loire ));
		repositoryWine.insert(new Wine("Rosé d\'Anjou", loire ));
		repositoryWine.insert(new Wine("Anjou-Coteaux-de-la-Loire", loire ));
		repositoryWine.insert(new Wine("Savennières", loire ));
		repositoryWine.insert(new Wine("Coteaux-du-layon", loire ));
		repositoryWine.insert(new Wine("Coteaux-du-layon Chaume", loire ));
		repositoryWine.insert(new Wine("Quarts-de-Chaume", loire ));
		repositoryWine.insert(new Wine("Bonnezeaux", loire ));
		repositoryWine.insert(new Wine("Coteaux-de-l\'Aubance", loire ));
		repositoryWine.insert(new Wine("Anjou Villages", loire ));
		repositoryWine.insert(new Wine("Anjou Villages Brissac", loire ));
		repositoryWine.insert(new Wine("Saumur", loire ));
		repositoryWine.insert(new Wine("Coteaux-de-Saumur", loire ));
		repositoryWine.insert(new Wine("Saumur-Champigny", loire ));
		repositoryWine.insert(new Wine("Cabernet de Saumur", loire ));
		repositoryWine.insert(new Wine("Maine-et-Loire", loire ));
		repositoryWine.insert(new Wine("Deux-Sèvres", loire ));
		repositoryWine.insert(new Wine("Indre-et-Loire", loire ));
		repositoryWine.insert(new Wine("Vienne", loire ));
		repositoryWine.insert(new Wine("Saint-Nicolas-de-Bourgueil", loire ));
		repositoryWine.insert(new Wine("Bourgueil", loire ));
		repositoryWine.insert(new Wine("Chinon", loire ));
		repositoryWine.insert(new Wine("Touraine", loire ));
		repositoryWine.insert(new Wine("Touraine-Azay-le-Rideau", loire ));
		repositoryWine.insert(new Wine("Touraine-Noble-Joué", loire ));
		repositoryWine.insert(new Wine("Vouvray", loire ));
		repositoryWine.insert(new Wine("Montlouis-sur-Loire", loire ));
		repositoryWine.insert(new Wine("Touraine-Amboise", loire ));
		repositoryWine.insert(new Wine("Touraine-Mesland", loire ));
		repositoryWine.insert(new Wine("Cheverny", loire ));
		repositoryWine.insert(new Wine("Cour-Cheverny", loire ));
		repositoryWine.insert(new Wine("Coteaux-du-Loir", loire ));
		repositoryWine.insert(new Wine("Jasnières", loire ));
		repositoryWine.insert(new Wine("Coteaux-du-Vendômois", loire ));
		repositoryWine.insert(new Wine("Haut-Poitou", loire ));
		repositoryWine.insert(new Wine("Loir-et-Cher", loire ));
		repositoryWine.insert(new Wine("Sarthe", loire ));
		repositoryWine.insert(new Wine("Coteaux-du-Cher-et-de-l\'Arnon", loire ));
		repositoryWine.insert(new Wine("Indre", loire ));
		repositoryWine.insert(new Wine("Orléans", loire ));
		repositoryWine.insert(new Wine("Orléans-Cléry", loire ));
		repositoryWine.insert(new Wine("Châteaumeillant", loire ));
		repositoryWine.insert(new Wine("Coteaux-du-Giennois", loire ));
		repositoryWine.insert(new Wine("Menetou-Salon", loire ));
		repositoryWine.insert(new Wine("Pouilly-Fumé", loire ));
		repositoryWine.insert(new Wine("Pouilly-sur-Loire", loire ));
		repositoryWine.insert(new Wine("Quincy", loire ));
		repositoryWine.insert(new Wine("Reuilly", loire ));
		repositoryWine.insert(new Wine("Sancerre", loire ));
		repositoryWine.insert(new Wine("Valençay", loire ));
		repositoryWine.insert(new Wine("Saint-Pourçain", loire ));
		repositoryWine.insert(new Wine("Côtes-d\'Auvergne", loire ));
		repositoryWine.insert(new Wine("Côte-Roannaise", loire ));
		repositoryWine.insert(new Wine("Côtes-du-Forez", loire ));
		repositoryWine.insert(new Wine("Loiret", loire ));
		repositoryWine.insert(new Wine("Cher", loire ));
		repositoryWine.insert(new Wine("Nièvre", loire ));
		repositoryWine.insert(new Wine("Allier", loire ));
		repositoryWine.insert(new Wine("Puy-de-Dôme", loire ));
		repositoryWine.insert(new Wine("Coteaux-Charitois", loire ));
		repositoryWine.insert(new Wine("Coteaux-de-Tannay", loire ));
		repositoryWine.insert(new Wine("Bourbonnais", loire ));
		repositoryWine.insert(new Wine("Urfé", loire ));
	}

	private void initAppellationsCotesDuRhone(Region cotesdurhone) {
		repositoryWine.insert(new Wine("Côte-Rôtie", cotesdurhone ));
		repositoryWine.insert(new Wine("Condrieu", cotesdurhone ));
		repositoryWine.insert(new Wine("Château-Grillet", cotesdurhone ));
		repositoryWine.insert(new Wine("Saint-Joseph", cotesdurhone ));
		repositoryWine.insert(new Wine("Cornas", cotesdurhone ));
		repositoryWine.insert(new Wine("Saint-Péray", cotesdurhone ));
		repositoryWine.insert(new Wine("Hermitage", cotesdurhone ));
		repositoryWine.insert(new Wine("Crozes-Hermitage", cotesdurhone ));
		repositoryWine.insert(new Wine("Brézème", cotesdurhone ));
		repositoryWine.insert(new Wine("Rasteau", cotesdurhone ));
		repositoryWine.insert(new Wine("Gigondas", cotesdurhone ));
		repositoryWine.insert(new Wine("Vacqueyras", cotesdurhone ));
		repositoryWine.insert(new Wine("Beaumes-de-Venise", cotesdurhone ));
		repositoryWine.insert(new Wine("Muscat de Beaumes-de-Venise", cotesdurhone ));
		repositoryWine.insert(new Wine("Châteauneuf-du-Pape", cotesdurhone ));
		repositoryWine.insert(new Wine("Tavel", cotesdurhone ));
		repositoryWine.insert(new Wine("Lirac", cotesdurhone ));
		repositoryWine.insert(new Wine("Cairanne", cotesdurhone ));
		repositoryWine.insert(new Wine("Chusclan", cotesdurhone ));
		repositoryWine.insert(new Wine("Laudun", cotesdurhone ));
		repositoryWine.insert(new Wine("Massif-d\'Uchaux", cotesdurhone ));
		repositoryWine.insert(new Wine("Plan de Dieu", cotesdurhone ));
		repositoryWine.insert(new Wine("Puyméras", cotesdurhone ));
		repositoryWine.insert(new Wine("Roaix", cotesdurhone ));
		repositoryWine.insert(new Wine("Rochegude", cotesdurhone ));
		repositoryWine.insert(new Wine("Rousset-les-Vignes", cotesdurhone ));
		repositoryWine.insert(new Wine("Sablet", cotesdurhone ));
		repositoryWine.insert(new Wine("Saint-Gervais", cotesdurhone ));
		repositoryWine.insert(new Wine("Saint-Maurice-sur-Eygues", cotesdurhone ));
		repositoryWine.insert(new Wine("Saint-Pantaléon-les-Vignes", cotesdurhone ));
		repositoryWine.insert(new Wine("Séguret", cotesdurhone ));
		repositoryWine.insert(new Wine("Signargues", cotesdurhone ));
		repositoryWine.insert(new Wine("Valréas", cotesdurhone ));
		repositoryWine.insert(new Wine("Visan", cotesdurhone ));
		repositoryWine.insert(new Wine("Coteaux-de-Die", cotesdurhone ));
		repositoryWine.insert(new Wine("Châtillon-en-Diois", cotesdurhone ));
		repositoryWine.insert(new Wine("Clairette de Die", cotesdurhone ));
		repositoryWine.insert(new Wine("Crémant de Die", cotesdurhone ));
		repositoryWine.insert(new Wine("Côtes-du-Vivarais", cotesdurhone ));
		repositoryWine.insert(new Wine("Grignan-les-Adhémar", cotesdurhone ));
		repositoryWine.insert(new Wine("Ventoux", cotesdurhone ));
		repositoryWine.insert(new Wine("Luberon", cotesdurhone ));
		repositoryWine.insert(new Wine("Costières-de-Nîmes", cotesdurhone ));
		repositoryWine.insert(new Wine("Clairette de Bellegarde", cotesdurhone ));
	}

	private void initAppellationsCorse(Region corse) {
		repositoryWine.insert(new Wine("Ajaccio", corse ));
		repositoryWine.insert(new Wine("Figari", corse ));
		repositoryWine.insert(new Wine("Porto Vecchio", corse ));
		repositoryWine.insert(new Wine("Sartène", corse ));
		repositoryWine.insert(new Wine("Calvi", corse ));
		repositoryWine.insert(new Wine("Patrimonio", corse ));
		repositoryWine.insert(new Wine("Cap Corse", corse ));
		repositoryWine.insert(new Wine("Côte Orientale", corse ));
	}

	private void initAppellationsProvence(Region provence) {
		repositoryWine.insert(new Wine("Côtes de Provence", provence ));
		repositoryWine.insert(new Wine("Coteaux d\'Aix en Provenc", provence ));
		repositoryWine.insert(new Wine("Coteaux Varois", provence ));
		repositoryWine.insert(new Wine("Coteaux de Pierrevert", provence ));
		repositoryWine.insert(new Wine("Côte du Luberon", provence ));
		repositoryWine.insert(new Wine("Châteauneuf du Pape", provence ));
		repositoryWine.insert(new Wine("Bandol", provence ));
		repositoryWine.insert(new Wine("Bellet", provence ));
		repositoryWine.insert(new Wine("Cassis", provence ));
		repositoryWine.insert(new Wine("Palette", provence ));
	}
}
