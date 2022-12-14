package exercise.domain.query;

import exercise.domain.Category;
import exercise.domain.query.assoc.QAssocArticle;
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
 * Query bean for Category.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean("v1")
public class QCategory extends TQRootBean<Category,QCategory> {

  private static final QCategory _alias = new QCategory(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QCategory alias() {
    return _alias;
  }

  public PLong<QCategory> id;
  public PString<QCategory> name;
  public QAssocArticle<QCategory> articles;


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
  public static QCategory forFetchGroup() {
    return new QCategory(FetchGroup.queryFor(Category.class));
  }

  /**
   * Construct using the default Database.
   */
  public QCategory() {
    super(Category.class);
  }

  /**
   * Construct with a given transaction.
   */
  public QCategory(Transaction transaction) {
    super(Category.class, transaction);
  }

  /**
   * Construct with a given Database.
   */
  public QCategory(Database database) {
    super(Category.class, database);
  }


  /**
   * Construct for Alias.
   */
  private QCategory(boolean dummy) {
    super(dummy);
  }

  /**
   * Private constructor for FetchGroup building.
   */
  private QCategory(Query<Category> fetchGroupQuery) {
    super(fetchGroupQuery);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PLong<QCategory> id = _alias.id;
    public static PString<QCategory> name = _alias.name;
    public static QAssocArticle<QCategory> articles = _alias.articles;
  }
}
