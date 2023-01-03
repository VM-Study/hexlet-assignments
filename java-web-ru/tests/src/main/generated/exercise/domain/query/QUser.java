package exercise.domain.query;

import exercise.domain.User;
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
 * Query bean for User.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean("v1")
public class QUser extends TQRootBean<User,QUser> {

  private static final QUser _alias = new QUser(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QUser alias() {
    return _alias;
  }

  public PLong<QUser> id;
  public PString<QUser> firstName;
  public PString<QUser> lastName;
  public PString<QUser> email;
  public PString<QUser> password;


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
  public static QUser forFetchGroup() {
    return new QUser(FetchGroup.queryFor(User.class));
  }

  /**
   * Construct using the default Database.
   */
  public QUser() {
    super(User.class);
  }

  /**
   * Construct with a given transaction.
   */
  public QUser(Transaction transaction) {
    super(User.class, transaction);
  }

  /**
   * Construct with a given Database.
   */
  public QUser(Database database) {
    super(User.class, database);
  }


  /**
   * Construct for Alias.
   */
  private QUser(boolean dummy) {
    super(dummy);
  }

  /**
   * Private constructor for FetchGroup building.
   */
  private QUser(Query<User> fetchGroupQuery) {
    super(fetchGroupQuery);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PLong<QUser> id = _alias.id;
    public static PString<QUser> firstName = _alias.firstName;
    public static PString<QUser> lastName = _alias.lastName;
    public static PString<QUser> email = _alias.email;
    public static PString<QUser> password = _alias.password;
  }
}
