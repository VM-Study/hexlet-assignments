package exercise.domain.query;

import exercise.domain.Article;
import exercise.domain.query.assoc.QAssocCategory;
import io.ebean.Database;
import io.ebean.FetchGroup;
import io.ebean.Query;
import io.ebean.Transaction;
import io.ebean.typequery.Generated;
import io.ebean.typequery.PLong;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;

/**
 * Query bean for Article.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean("v1")
public class QArticle extends TQRootBean<Article,QArticle> {

  private static final QArticle _alias = new QArticle(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QArticle alias() {
    return _alias;
  }

  public PLong<QArticle> id;
  public PString<QArticle> title;
  public PString<QArticle> body;
  public QAssocCategory<QArticle> category;


  /**
   * Return a query bean used to build a FetchGroup.
   * <p>
   * FetchGroups are immutable and threadsafe and can be used by many
   * concurrent queries. We typically stored FetchGroup as a static final field.
   * <p>
   * Example creating and using a FetchGroup.
   * <pre>{@code
   * 
   * static final FetchGroup<Customer> fetchGroup = 
   *   QCustomer.forFetchGroup()
   *     .shippingAddress.fetch()
   *     .contacts.fetch()
   *     .buildFetchGroup();
   * 
   * List<Customer> customers = new QCustomer()
   *   .select(fetchGroup)
   *   .findList();
   * 
   * }</pre>
   */
  public static QArticle forFetchGroup() {
    return new QArticle(FetchGroup.queryFor(Article.class));
  }

  /**
   * Construct using the default Database.
   */
  public QArticle() {
    super(Article.class);
  }

  /**
   * Construct with a given transaction.
   */
  public QArticle(Transaction transaction) {
    super(Article.class, transaction);
  }

  /**
   * Construct with a given Database.
   */
  public QArticle(Database database) {
    super(Article.class, database);
  }


  /**
   * Construct for Alias.
   */
  private QArticle(boolean dummy) {
    super(dummy);
  }

  /**
   * Private constructor for FetchGroup building.
   */
  private QArticle(Query<Article> fetchGroupQuery) {
    super(fetchGroupQuery);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PLong<QArticle> id = _alias.id;
    public static PString<QArticle> title = _alias.title;
    public static PString<QArticle> body = _alias.body;
    public static QAssocCategory<QArticle> category = _alias.category;
  }
}
