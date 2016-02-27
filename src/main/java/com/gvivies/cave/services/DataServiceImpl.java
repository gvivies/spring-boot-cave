package com.gvivies.cave.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvivies.cave.model.Classification;
import com.gvivies.cave.model.Dealer;
import com.gvivies.cave.model.Region;
import com.gvivies.cave.model.Wine;
import com.gvivies.cave.repositories.ClassificationRepository;
import com.gvivies.cave.repositories.DealerRepository;
import com.gvivies.cave.repositories.RegionRepository;
import com.gvivies.cave.repositories.WineRepository;

@Service
public class DataServiceImpl implements DataService {

	private final static String UNKNOWN = "Non connu";

	@Autowired
	private WineRepository repositoryWine;

	@Autowired
	private RegionRepository repositoryRegion;

	@Autowired
	private DealerRepository repositoryDealer;

	@Autowired
	private ClassificationRepository repositoryClassification;

	@Override
	public void initForUser(String owner) {

		if (repositoryDealer.findByNameAndOwnedBy(UNKNOWN, owner) != null) {
			return;
		}

		initClassifications(owner);
		initDealer(owner);
		initRegions(owner);

		Region bordeaux = repositoryRegion.findByNameAndOwnedBy("Bordeaux", owner);
		initAppellationsBordeaux(bordeaux, owner);

		Region alsace = repositoryRegion.findByNameAndOwnedBy("Alsace", owner);
		initAppellationsAlsace(alsace, owner);

		Region bourgogne = repositoryRegion.findByNameAndOwnedBy("Bourgogne", owner);
		initAppellationsBourgogne(bourgogne, owner);

		Region sudouest = repositoryRegion.findByNameAndOwnedBy("Sud-Ouest", owner);
		initAppellationsSudOuest(sudouest, owner);

		Region loire = repositoryRegion.findByNameAndOwnedBy("Loire", owner);
		initAppellationsLoire(loire, owner);

		Region champagne = repositoryRegion.findByNameAndOwnedBy("Champagne", owner);
		initAppellationsChampagne(champagne, owner);

		Region cotesdurhone = repositoryRegion.findByNameAndOwnedBy("Côtes du Rhône", owner);
		initAppellationsCotesDuRhone(cotesdurhone, owner);

		Region corse = repositoryRegion.findByNameAndOwnedBy("Corse", owner);
		initAppellationsCorse(corse, owner);

		Region provence = repositoryRegion.findByNameAndOwnedBy("Provence", owner);
		initAppellationsProvence(provence, owner);

		Region languedoc = repositoryRegion.findByNameAndOwnedBy("Languedoc-Roussillon", owner);
		initAppellationsLanguedoc(languedoc, owner);
	}

	private void initAppellationsLanguedoc(Region languedoc, String owner) {
		repositoryWine.insert(new Wine("Côtes-Catalanes", languedoc, owner));
		repositoryWine.insert(new Wine("Côte-Vermeille", languedoc, owner));
		repositoryWine.insert(new Wine("Pyrénées-Orientales", languedoc, owner));
		repositoryWine.insert(new Wine("Collioure", languedoc, owner));
		repositoryWine.insert(new Wine("Côtes-du-Roussillon", languedoc, owner));
		repositoryWine.insert(new Wine("Côtes-du-Roussillon Les Aspres", languedoc, owner));
		repositoryWine.insert(new Wine("Côtes-du-Roussillon Villages", languedoc, owner));
		repositoryWine.insert(new Wine("Caramany", languedoc, owner));
		repositoryWine.insert(new Wine("Lesquerde", languedoc, owner));
		repositoryWine.insert(new Wine("Tautavel", languedoc, owner));
		repositoryWine.insert(new Wine("Latour-de-France", languedoc, owner));
		repositoryWine.insert(new Wine("Banyuls", languedoc, owner));
		repositoryWine.insert(new Wine("Banyuls Grand Cru", languedoc, owner));
		repositoryWine.insert(new Wine("Grand Roussillon", languedoc, owner));
		repositoryWine.insert(new Wine("Maury", languedoc, owner));
		repositoryWine.insert(new Wine("Muscat de Rivesaltes", languedoc, owner));
		repositoryWine.insert(new Wine("Rivesaltes", languedoc, owner));
		repositoryWine.insert(new Wine("Cabrières", languedoc, owner));
		repositoryWine.insert(new Wine("Clairette du Languedoc", languedoc, owner));
		repositoryWine.insert(new Wine("Faugères", languedoc, owner));
		repositoryWine.insert(new Wine("Grès-de-Montpellier", languedoc, owner));
		repositoryWine.insert(new Wine("La Clape", languedoc, owner));
		repositoryWine.insert(new Wine("La Méjanelle", languedoc, owner));
		repositoryWine.insert(new Wine("Montpeyroux", languedoc, owner));
		repositoryWine.insert(new Wine("Pézenas", languedoc, owner));
		repositoryWine.insert(new Wine("Picpoul de Pinet", languedoc, owner));
		repositoryWine.insert(new Wine("Pic-Saint-Loup", languedoc, owner));
		repositoryWine.insert(new Wine("Quatourze", languedoc, owner));
		repositoryWine.insert(new Wine("Saint-Chinian", languedoc, owner));
		repositoryWine.insert(new Wine("Saint-Christol", languedoc, owner));
		repositoryWine.insert(new Wine("Saint-Drézéry", languedoc, owner));
		repositoryWine.insert(new Wine("Saint-Georges-d\'orques", languedoc, owner));
		repositoryWine.insert(new Wine("Saint-Saturnin", languedoc, owner));
		repositoryWine.insert(new Wine("Terrasses-du-Larzac", languedoc, owner));
		repositoryWine.insert(new Wine("Sommières", languedoc, owner));
		repositoryWine.insert(new Wine("Vérargues", languedoc, owner));
		repositoryWine.insert(new Wine("Blanquette de Limoux", languedoc, owner));
		repositoryWine.insert(new Wine("Crémant de Limoux", languedoc, owner));
		repositoryWine.insert(new Wine("Limoux", languedoc, owner));
		repositoryWine.insert(new Wine("Cabardès", languedoc, owner));
		repositoryWine.insert(new Wine("Corbières", languedoc, owner));
		repositoryWine.insert(new Wine("Corbières-Boutenac", languedoc, owner));
		repositoryWine.insert(new Wine("Languedoc", languedoc, owner));
		repositoryWine.insert(new Wine("Fitou", languedoc, owner));
		repositoryWine.insert(new Wine("Minervois", languedoc, owner));
		repositoryWine.insert(new Wine("Minervois-la-Livinière", languedoc, owner));
		repositoryWine.insert(new Wine("Malepère", languedoc, owner));
		repositoryWine.insert(new Wine("Muscat de Frontignan", languedoc, owner));
		repositoryWine.insert(new Wine("Muscat de Mireval", languedoc, owner));
		repositoryWine.insert(new Wine("Muscat de Saint-Jean-de-Minervois", languedoc, owner));
		repositoryWine.insert(new Wine("Muscat de Lune", languedoc, owner));
	}

	private void initAppellationsChampagne(Region champagne, String owner) {
		repositoryWine.insert(new Wine("Champagne", champagne, owner));
		repositoryWine.insert(new Wine("Coteaux champenois", champagne, owner));
		repositoryWine.insert(new Wine("Rosé des Riceys", champagne, owner));
	}

	private void initRegions(String owner) {
		repositoryRegion.insert(new Region("Bordeaux", owner));
		repositoryRegion.insert(new Region("Bourgogne", owner));
		repositoryRegion.insert(new Region("Sud-Ouest", owner));
		repositoryRegion.insert(new Region("Loire", owner));
		repositoryRegion.insert(new Region("Alsace", owner));
		repositoryRegion.insert(new Region("Champagne", owner));
		repositoryRegion.insert(new Region("Côtes du Rhône", owner));
		repositoryRegion.insert(new Region("Corse", owner));
		repositoryRegion.insert(new Region("Provence", owner));
		repositoryRegion.insert(new Region("Languedoc-Roussillon", owner));
	}

	private void initDealer(String owner) {
		repositoryDealer.insert(new Dealer(UNKNOWN, "", "", "", "", "", "", "", "", "", null, owner));
	}

	private void initAppellationsBordeaux(Region bordeaux, String owner) {
		repositoryWine.insert(new Wine("Médoc", bordeaux, owner));
		repositoryWine.insert(new Wine("Haut-Médoc", bordeaux, owner));
		repositoryWine.insert(new Wine("Saint-Estèphe", bordeaux, owner));
		repositoryWine.insert(new Wine("Pauillac", bordeaux, owner));
		repositoryWine.insert(new Wine("Saint-Julien", bordeaux, owner));
		repositoryWine.insert(new Wine("Listrac-Médoc", bordeaux, owner));
		repositoryWine.insert(new Wine("Moulis-en-Médoc", bordeaux, owner));
		repositoryWine.insert(new Wine("Margaux", bordeaux, owner));
		repositoryWine.insert(new Wine("Pessac-Léognan", bordeaux, owner));
		repositoryWine.insert(new Wine("Graves-Supérieurs", bordeaux, owner));
		repositoryWine.insert(new Wine("Graves", bordeaux, owner));
		repositoryWine.insert(new Wine("Cérons", bordeaux, owner));
		repositoryWine.insert(new Wine("Barsac", bordeaux, owner));
		repositoryWine.insert(new Wine("Sauternes", bordeaux, owner));
		repositoryWine.insert(new Wine("Entre-deux-mers", bordeaux, owner));
		repositoryWine.insert(new Wine("Graves-de-vayres", bordeaux, owner));
		repositoryWine.insert(new Wine("Premières-côtes-de-Bordeaux", bordeaux, owner));
		repositoryWine.insert(new Wine("Cadillac", bordeaux, owner));
		repositoryWine.insert(new Wine("Cadillac-côtes-de-Bordeaux", bordeaux, owner));
		repositoryWine.insert(new Wine("Loupiac", bordeaux, owner));
		repositoryWine.insert(new Wine("Sainte-Croix-du-Mont", bordeaux, owner));
		repositoryWine.insert(new Wine("Bordeaux-Haut-Benauge", bordeaux, owner));
		repositoryWine.insert(new Wine("Côtes-de-Bordeaux-Saint-Macaire", bordeaux, owner));
		repositoryWine.insert(new Wine("Sainte-Foy-Bordeaux", bordeaux, owner));
		repositoryWine.insert(new Wine("Fronsac", bordeaux, owner));
		repositoryWine.insert(new Wine("Canon-Fronsac", bordeaux, owner));
		repositoryWine.insert(new Wine("Pomerol", bordeaux, owner));
		repositoryWine.insert(new Wine("Lalande-de-Pomerol", bordeaux, owner));
		repositoryWine.insert(new Wine("Néac", bordeaux, owner));
		repositoryWine.insert(new Wine("Saint-Emilion", bordeaux, owner));
		repositoryWine.insert(new Wine("Montagne-Saint-Emilion", bordeaux, owner));
		repositoryWine.insert(new Wine("Saint-georges-Saint-Emilion", bordeaux, owner));
		repositoryWine.insert(new Wine("Lussac-Saint-Emilion", bordeaux, owner));
		repositoryWine.insert(new Wine("Puisseguin-Saint-Emilion", bordeaux, owner));
		repositoryWine.insert(new Wine("Francs-côtes-de-Bordeaux", bordeaux, owner));
		repositoryWine.insert(new Wine("Castillon-côtes-de-Bordeaux", bordeaux, owner));
		repositoryWine.insert(new Wine("Blaye", bordeaux, owner));
		repositoryWine.insert(new Wine("Côtes-de-Blaye", bordeaux, owner));
		repositoryWine.insert(new Wine("Blaye-côtes-de-Bordeaux", bordeaux, owner));
		repositoryWine.insert(new Wine("Côtes-de-Bourg", bordeaux, owner));
	}

	private void initAppellationsAlsace(Region alsace, String owner) {
		repositoryWine.insert(new Wine("Riesling", alsace, owner));
		repositoryWine.insert(new Wine("Pinot-gris", alsace, owner));
		repositoryWine.insert(new Wine("Gewurztraminer", alsace, owner));
		repositoryWine.insert(new Wine("Muscat", alsace, owner));
		repositoryWine.insert(new Wine("Pinot-noir", alsace, owner));
		repositoryWine.insert(new Wine("Sylvaner", alsace, owner));
		repositoryWine.insert(new Wine("Klevener de Heiligenstein", alsace, owner));
		repositoryWine.insert(new Wine("Pinot", alsace, owner));
		repositoryWine.insert(new Wine("Chasselas", alsace, owner));
		repositoryWine.insert(new Wine("Edelzwicker", alsace, owner));
	}

	private void initAppellationsBourgogne(Region bourgogne, String owner) {
		repositoryWine.insert(new Wine("Petit-chablis", bourgogne, owner));
		repositoryWine.insert(new Wine("Chablis", bourgogne, owner));
		repositoryWine.insert(new Wine("Chablis Grand Cru", bourgogne, owner));
		repositoryWine.insert(new Wine("Irancy", bourgogne, owner));
		repositoryWine.insert(new Wine("Saint-Bris", bourgogne, owner));
		repositoryWine.insert(new Wine("Côte-d’Auxerre", bourgogne, owner));
		repositoryWine.insert(new Wine("Chitry", bourgogne, owner));
		repositoryWine.insert(new Wine("Coulanges-La-Vineuse", bourgogne, owner));
		repositoryWine.insert(new Wine("Tonnerre", bourgogne, owner));
		repositoryWine.insert(new Wine("Epineuil", bourgogne, owner));
		repositoryWine.insert(new Wine("Vézelay", bourgogne, owner));
		repositoryWine.insert(new Wine("Côte-Saint-Jacques", bourgogne, owner));
		repositoryWine.insert(new Wine("Montrecul", bourgogne, owner));
		repositoryWine.insert(new Wine("Le-Chapitre", bourgogne, owner));
		repositoryWine.insert(new Wine("Fixin", bourgogne, owner));
		repositoryWine.insert(new Wine("Marsannay", bourgogne, owner));
		repositoryWine.insert(new Wine("Gevrey-Chambertin", bourgogne, owner));
		repositoryWine.insert(new Wine("Chambertin", bourgogne, owner));
		repositoryWine.insert(new Wine("Chambertin-Clos-de-Bèze", bourgogne, owner));
		repositoryWine.insert(new Wine("Chapelle-Chambertin", bourgogne, owner));
		repositoryWine.insert(new Wine("Charmes-Chambertin", bourgogne, owner));
		repositoryWine.insert(new Wine("Mazis-Chambertin", bourgogne, owner));
		repositoryWine.insert(new Wine("Griotte-Chambertin", bourgogne, owner));
		repositoryWine.insert(new Wine("Latricières-Chambertin", bourgogne, owner));
		repositoryWine.insert(new Wine("Ruchottes-Chambertin", bourgogne, owner));
		repositoryWine.insert(new Wine("Mazoyères-Chambertin", bourgogne, owner));
		repositoryWine.insert(new Wine("Morey-Saint-Denis", bourgogne, owner));
		repositoryWine.insert(new Wine("Clos-de-Tart", bourgogne, owner));
		repositoryWine.insert(new Wine("Clos-Saint-Denis", bourgogne, owner));
		repositoryWine.insert(new Wine("Clos-de-la-Roche", bourgogne, owner));
		repositoryWine.insert(new Wine("Clos-des-Lambrays", bourgogne, owner));
		repositoryWine.insert(new Wine("Chambolle-Musigny", bourgogne, owner));
		repositoryWine.insert(new Wine("Musigny", bourgogne, owner));
		repositoryWine.insert(new Wine("Bonnes-Mares", bourgogne, owner));
		repositoryWine.insert(new Wine("Vougeot", bourgogne, owner));
		repositoryWine.insert(new Wine("Clos-Vougeot", bourgogne, owner));
		repositoryWine.insert(new Wine("Echezeaux", bourgogne, owner));
		repositoryWine.insert(new Wine("Grands-Echezeaux", bourgogne, owner));
		repositoryWine.insert(new Wine("Vosne-Romanée", bourgogne, owner));
		repositoryWine.insert(new Wine("Romanée-Conti", bourgogne, owner));
		repositoryWine.insert(new Wine("Richebourg", bourgogne, owner));
		repositoryWine.insert(new Wine("La-Romanée", bourgogne, owner));
		repositoryWine.insert(new Wine("La-Tâche", bourgogne, owner));
		repositoryWine.insert(new Wine("Romanée-Saint-Vivant", bourgogne, owner));
		repositoryWine.insert(new Wine("La-Grande-Rue", bourgogne, owner));
		repositoryWine.insert(new Wine("Nuits-Saint-Georges", bourgogne, owner));
		repositoryWine.insert(new Wine("Côte-de-Nuits-Villages", bourgogne, owner));
		repositoryWine.insert(new Wine("Hautes-Côtes-de-Nuits", bourgogne, owner));
		repositoryWine.insert(new Wine("Ladoix", bourgogne, owner));
		repositoryWine.insert(new Wine("La-Chapelle-Notre-Dame", bourgogne, owner));
		repositoryWine.insert(new Wine("Aloxe-Corton", bourgogne, owner));
		repositoryWine.insert(new Wine("Corton", bourgogne, owner));
		repositoryWine.insert(new Wine("Corton-Charlemagne", bourgogne, owner));
		repositoryWine.insert(new Wine("Charlemagne", bourgogne, owner));
		repositoryWine.insert(new Wine("Chorey-Lès-Beaune", bourgogne, owner));
		repositoryWine.insert(new Wine("Savigny-Lès-Beaune", bourgogne, owner));
		repositoryWine.insert(new Wine("Pernand-Vergelesses", bourgogne, owner));
		repositoryWine.insert(new Wine("Beaune", bourgogne, owner));
		repositoryWine.insert(new Wine("Côte-de-Beaune", bourgogne, owner));
		repositoryWine.insert(new Wine("Pommard", bourgogne, owner));
		repositoryWine.insert(new Wine("Volnay", bourgogne, owner));
		repositoryWine.insert(new Wine("Meursault", bourgogne, owner));
		repositoryWine.insert(new Wine("Auxey-Duresses", bourgogne, owner));
		repositoryWine.insert(new Wine("Monthélie", bourgogne, owner));
		repositoryWine.insert(new Wine("Puligny-Montrachet", bourgogne, owner));
		repositoryWine.insert(new Wine("Chevalier-Montrachet", bourgogne, owner));
		repositoryWine.insert(new Wine("Bienvenues-Bâtard-Montrachet", bourgogne, owner));
		repositoryWine.insert(new Wine("Montrachet", bourgogne, owner));
		repositoryWine.insert(new Wine("Bâtard-Montrachet", bourgogne, owner));
		repositoryWine.insert(new Wine("Chassagne-Montrachet", bourgogne, owner));
		repositoryWine.insert(new Wine("Criots-Bâtard-Montrachet", bourgogne, owner));
		repositoryWine.insert(new Wine("Saint-Aubin", bourgogne, owner));
		repositoryWine.insert(new Wine("Saint-Romain", bourgogne, owner));
		repositoryWine.insert(new Wine("Blagny", bourgogne, owner));
		repositoryWine.insert(new Wine("Santenay", bourgogne, owner));
		repositoryWine.insert(new Wine("Maranges", bourgogne, owner));
		repositoryWine.insert(new Wine("Côte-de-Beaune-Villages", bourgogne, owner));
		repositoryWine.insert(new Wine("Hautes-Côtes-de-Beaune", bourgogne, owner));
		repositoryWine.insert(new Wine("Bouzeron", bourgogne, owner));
		repositoryWine.insert(new Wine("Rully", bourgogne, owner));
		repositoryWine.insert(new Wine("Mercurey", bourgogne, owner));
		repositoryWine.insert(new Wine("Givry", bourgogne, owner));
		repositoryWine.insert(new Wine("Montagny", bourgogne, owner));
		repositoryWine.insert(new Wine("Côte-Chalonnaise", bourgogne, owner));
		repositoryWine.insert(new Wine("Côtes-du-Couchois", bourgogne, owner));
		repositoryWine.insert(new Wine("Pouilly-Fuissé", bourgogne, owner));
		repositoryWine.insert(new Wine("Pouilly-Vinzelles", bourgogne, owner));
		repositoryWine.insert(new Wine("Pouilly-Loché", bourgogne, owner));
		repositoryWine.insert(new Wine("Saint-véran", bourgogne, owner));
		repositoryWine.insert(new Wine("Viré-clessé", bourgogne, owner));
		repositoryWine.insert(new Wine("Mâcon", bourgogne, owner));
		repositoryWine.insert(new Wine("Mâcon-villages", bourgogne, owner));
		repositoryWine.insert(new Wine("Bourgogne", bourgogne, owner));
		repositoryWine.insert(new Wine("Bourgogne-aligoté", bourgogne, owner));
		repositoryWine.insert(new Wine("Bourgogne-Passe-Tout-Grains", bourgogne, owner));
		repositoryWine.insert(new Wine("Coteaux-Bourguignons", bourgogne, owner));
		repositoryWine.insert(new Wine("Crémant de Bourgogne", bourgogne, owner));
		repositoryWine.insert(new Wine("Bourgogne-Mousseux", bourgogne, owner));
	}

	private void initAppellationsSudOuest(Region sudouest, String owner) {
		repositoryWine.insert(new Wine("Bergeracois Bergerac", sudouest, owner));
		repositoryWine.insert(new Wine("Côtes-de-Bergerac", sudouest, owner));
		repositoryWine.insert(new Wine("Montravel", sudouest, owner));
		repositoryWine.insert(new Wine("Haut-Montravel", sudouest, owner));
		repositoryWine.insert(new Wine("Côtes-de-Montravel", sudouest, owner));
		repositoryWine.insert(new Wine("Monbazillac", sudouest, owner));
		repositoryWine.insert(new Wine("Pécharmant", sudouest, owner));
		repositoryWine.insert(new Wine("Rosette", sudouest, owner));
		repositoryWine.insert(new Wine("Saussignac", sudouest, owner));
		repositoryWine.insert(new Wine("Périgord", sudouest, owner));
		repositoryWine.insert(new Wine("Côtes-du-Marmandais", sudouest, owner));
		repositoryWine.insert(new Wine("Côtes-de-duras", sudouest, owner));
		repositoryWine.insert(new Wine("Buzet", sudouest, owner));
		repositoryWine.insert(new Wine("Thézac-Perricard", sudouest, owner));
		repositoryWine.insert(new Wine("Côtes-du-brulhois", sudouest, owner));
		repositoryWine.insert(new Wine("Fronton", sudouest, owner));
		repositoryWine.insert(new Wine("Lavilledieu", sudouest, owner));
		repositoryWine.insert(new Wine("Agenais", sudouest, owner));
		repositoryWine.insert(new Wine("Coteaux-et-Terrasses-de-Montauban", sudouest, owner));
		repositoryWine.insert(new Wine("Cahors", sudouest, owner));
		repositoryWine.insert(new Wine("Coteaux-du-Quercy", sudouest, owner));
		repositoryWine.insert(new Wine("Coteaux-de-Glanes", sudouest, owner));
		repositoryWine.insert(new Wine("Entraygues-et-du-Fel", sudouest, owner));
		repositoryWine.insert(new Wine("Estaing", sudouest, owner));
		repositoryWine.insert(new Wine("Gaillac", sudouest, owner));
		repositoryWine.insert(new Wine("Gaillac-Premières-Côtes", sudouest, owner));
		repositoryWine.insert(new Wine("Côtes-du-Tarn", sudouest, owner));
		repositoryWine.insert(new Wine("Côtes-de-Millau", sudouest, owner));
		repositoryWine.insert(new Wine("Marcillac", sudouest, owner));
		repositoryWine.insert(new Wine("Armagnac", sudouest, owner));
		repositoryWine.insert(new Wine("Floc de Gascogne", sudouest, owner));
		repositoryWine.insert(new Wine("Côtes-de-Saint-Mont", sudouest, owner));
		repositoryWine.insert(new Wine("Madiran", sudouest, owner));
		repositoryWine.insert(new Wine("Pacherenc-du-Vic-Bilh", sudouest, owner));
		repositoryWine.insert(new Wine("Côtes-du-Condomois", sudouest, owner));
		repositoryWine.insert(new Wine("Côtes-de-Gascogne", sudouest, owner));
		repositoryWine.insert(new Wine("Côtes-de-Montestruc", sudouest, owner));
		repositoryWine.insert(new Wine("Béarn", sudouest, owner));
		repositoryWine.insert(new Wine("Tursan", sudouest, owner));
		repositoryWine.insert(new Wine("Jurançon", sudouest, owner));
		repositoryWine.insert(new Wine("Bigorre", sudouest, owner));
		repositoryWine.insert(new Wine("Coteaux-de-Chalosse", sudouest, owner));
		repositoryWine.insert(new Wine("Terroirs-landais", sudouest, owner));
		repositoryWine.insert(new Wine("Irouléguy", sudouest, owner));
	}

	private void initAppellationsLoire(Region loire, String owner) {
		repositoryWine.insert(new Wine("Crémant de Loire", loire, owner));
		repositoryWine.insert(new Wine("Rosé de Loire", loire, owner));
		repositoryWine.insert(new Wine("Val-de-loire	", loire, owner));
		repositoryWine.insert(new Wine("Gros-Plant-du-Pays-Nantais", loire, owner));
		repositoryWine.insert(new Wine("Muscadet", loire, owner));
		repositoryWine.insert(new Wine("Muscadet-Coteaux-de-la-Loire", loire, owner));
		repositoryWine.insert(new Wine("Coteaux-d\'Ancenis", loire, owner));
		repositoryWine.insert(new Wine("Muscadet-Sèvre-et-Maine", loire, owner));
		repositoryWine.insert(new Wine("Muscadet-Côtes-de-Grandlieu", loire, owner));
		repositoryWine.insert(new Wine("Fiefs-Vendéens", loire, owner));
		repositoryWine.insert(new Wine("Loire-Atlantique", loire, owner));
		repositoryWine.insert(new Wine("Vendée", loire, owner));
		repositoryWine.insert(new Wine("Anjou", loire, owner));
		repositoryWine.insert(new Wine("Cabernet d\'Anjou", loire, owner));
		repositoryWine.insert(new Wine("Rosé d\'Anjou", loire, owner));
		repositoryWine.insert(new Wine("Anjou-Coteaux-de-la-Loire", loire, owner));
		repositoryWine.insert(new Wine("Savennières", loire, owner));
		repositoryWine.insert(new Wine("Coteaux-du-layon", loire, owner));
		repositoryWine.insert(new Wine("Coteaux-du-layon Chaume", loire, owner));
		repositoryWine.insert(new Wine("Quarts-de-Chaume", loire, owner));
		repositoryWine.insert(new Wine("Bonnezeaux", loire, owner));
		repositoryWine.insert(new Wine("Coteaux-de-l\'Aubance", loire, owner));
		repositoryWine.insert(new Wine("Anjou Villages", loire, owner));
		repositoryWine.insert(new Wine("Anjou Villages Brissac", loire, owner));
		repositoryWine.insert(new Wine("Saumur", loire, owner));
		repositoryWine.insert(new Wine("Coteaux-de-Saumur", loire, owner));
		repositoryWine.insert(new Wine("Saumur-Champigny", loire, owner));
		repositoryWine.insert(new Wine("Cabernet de Saumur", loire, owner));
		repositoryWine.insert(new Wine("Maine-et-Loire", loire, owner));
		repositoryWine.insert(new Wine("Deux-Sèvres", loire, owner));
		repositoryWine.insert(new Wine("Indre-et-Loire", loire, owner));
		repositoryWine.insert(new Wine("Vienne", loire, owner));
		repositoryWine.insert(new Wine("Saint-Nicolas-de-Bourgueil", loire, owner));
		repositoryWine.insert(new Wine("Bourgueil", loire, owner));
		repositoryWine.insert(new Wine("Chinon", loire, owner));
		repositoryWine.insert(new Wine("Touraine", loire, owner));
		repositoryWine.insert(new Wine("Touraine-Azay-le-Rideau", loire, owner));
		repositoryWine.insert(new Wine("Touraine-Noble-Joué", loire, owner));
		repositoryWine.insert(new Wine("Vouvray", loire, owner));
		repositoryWine.insert(new Wine("Montlouis-sur-Loire", loire, owner));
		repositoryWine.insert(new Wine("Touraine-Amboise", loire, owner));
		repositoryWine.insert(new Wine("Touraine-Mesland", loire, owner));
		repositoryWine.insert(new Wine("Cheverny", loire, owner));
		repositoryWine.insert(new Wine("Cour-Cheverny", loire, owner));
		repositoryWine.insert(new Wine("Coteaux-du-Loir", loire, owner));
		repositoryWine.insert(new Wine("Jasnières", loire, owner));
		repositoryWine.insert(new Wine("Coteaux-du-Vendômois", loire, owner));
		repositoryWine.insert(new Wine("Haut-Poitou", loire, owner));
		repositoryWine.insert(new Wine("Loir-et-Cher", loire, owner));
		repositoryWine.insert(new Wine("Sarthe", loire, owner));
		repositoryWine.insert(new Wine("Coteaux-du-Cher-et-de-l\'Arnon", loire, owner));
		repositoryWine.insert(new Wine("Indre", loire, owner));
		repositoryWine.insert(new Wine("Orléans", loire, owner));
		repositoryWine.insert(new Wine("Orléans-Cléry", loire, owner));
		repositoryWine.insert(new Wine("Châteaumeillant", loire, owner));
		repositoryWine.insert(new Wine("Coteaux-du-Giennois", loire, owner));
		repositoryWine.insert(new Wine("Menetou-Salon", loire, owner));
		repositoryWine.insert(new Wine("Pouilly-Fumé", loire, owner));
		repositoryWine.insert(new Wine("Pouilly-sur-Loire", loire, owner));
		repositoryWine.insert(new Wine("Quincy", loire, owner));
		repositoryWine.insert(new Wine("Reuilly", loire, owner));
		repositoryWine.insert(new Wine("Sancerre", loire, owner));
		repositoryWine.insert(new Wine("Valençay", loire, owner));
		repositoryWine.insert(new Wine("Saint-Pourçain", loire, owner));
		repositoryWine.insert(new Wine("Côtes-d\'Auvergne", loire, owner));
		repositoryWine.insert(new Wine("Côte-Roannaise", loire, owner));
		repositoryWine.insert(new Wine("Côtes-du-Forez", loire, owner));
		repositoryWine.insert(new Wine("Loiret", loire, owner));
		repositoryWine.insert(new Wine("Cher", loire, owner));
		repositoryWine.insert(new Wine("Nièvre", loire, owner));
		repositoryWine.insert(new Wine("Allier", loire, owner));
		repositoryWine.insert(new Wine("Puy-de-Dôme", loire, owner));
		repositoryWine.insert(new Wine("Coteaux-Charitois", loire, owner));
		repositoryWine.insert(new Wine("Coteaux-de-Tannay", loire, owner));
		repositoryWine.insert(new Wine("Bourbonnais", loire, owner));
		repositoryWine.insert(new Wine("Urfé", loire, owner));
	}

	private void initAppellationsCotesDuRhone(Region cotesdurhone, String owner) {
		repositoryWine.insert(new Wine("Côte-Rôtie", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Condrieu", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Château-Grillet", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Saint-Joseph", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Cornas", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Saint-Péray", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Hermitage", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Crozes-Hermitage", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Brézème", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Rasteau", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Gigondas", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Vacqueyras", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Beaumes-de-Venise", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Muscat de Beaumes-de-Venise", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Châteauneuf-du-Pape", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Tavel", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Lirac", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Cairanne", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Chusclan", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Laudun", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Massif-d\'Uchaux", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Plan de Dieu", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Puyméras", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Roaix", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Rochegude", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Rousset-les-Vignes", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Sablet", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Saint-Gervais", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Saint-Maurice-sur-Eygues", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Saint-Pantaléon-les-Vignes", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Séguret", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Signargues", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Valréas", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Visan", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Coteaux-de-Die", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Châtillon-en-Diois", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Clairette de Die", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Crémant de Die", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Côtes-du-Vivarais", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Grignan-les-Adhémar", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Ventoux", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Luberon", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Costières-de-Nîmes", cotesdurhone, owner));
		repositoryWine.insert(new Wine("Clairette de Bellegarde", cotesdurhone, owner));
	}

	private void initAppellationsCorse(Region corse, String owner) {
		repositoryWine.insert(new Wine("Ajaccio", corse, owner));
		repositoryWine.insert(new Wine("Figari", corse, owner));
		repositoryWine.insert(new Wine("Porto Vecchio", corse, owner));
		repositoryWine.insert(new Wine("Sartène", corse, owner));
		repositoryWine.insert(new Wine("Calvi", corse, owner));
		repositoryWine.insert(new Wine("Patrimonio", corse, owner));
		repositoryWine.insert(new Wine("Cap Corse", corse, owner));
		repositoryWine.insert(new Wine("Côte Orientale", corse, owner));
	}

	private void initAppellationsProvence(Region provence, String owner) {
		repositoryWine.insert(new Wine("Côtes de Provence", provence, owner));
		repositoryWine.insert(new Wine("Coteaux d\'Aix en Provenc", provence, owner));
		repositoryWine.insert(new Wine("Coteaux Varois", provence, owner));
		repositoryWine.insert(new Wine("Coteaux de Pierrevert", provence, owner));
		repositoryWine.insert(new Wine("Côte du Luberon", provence, owner));
		repositoryWine.insert(new Wine("Châteauneuf du Pape", provence, owner));
		repositoryWine.insert(new Wine("Bandol", provence, owner));
		repositoryWine.insert(new Wine("Bellet", provence, owner));
		repositoryWine.insert(new Wine("Cassis", provence, owner));
		repositoryWine.insert(new Wine("Palette", provence, owner));
	}

	private void initClassifications(String owner) {
		repositoryClassification.insert(new Classification("Blanc", owner));
		repositoryClassification.insert(new Classification("Gris", owner));
		repositoryClassification.insert(new Classification("Rosé", owner));
		repositoryClassification.insert(new Classification("Rouge", owner));
		repositoryClassification.insert(new Classification("Champagne", owner));
		repositoryClassification.insert(new Classification("Champagne rosé", owner));
		repositoryClassification.insert(new Classification("Mousseux", owner));
		repositoryClassification.insert(new Classification("Vin cuit", owner));
	}

}
