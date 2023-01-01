package exercise.domain.query.assoc;

import exercise.domain.Category;
import exercise.domain.query.QCategory;
import io.ebean.Transaction;
import io.ebean.typequery.Generated;
import io.ebean.typequery.PLong;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;

/**
 * Association query bean for AssocCategory.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean("v1")
public class QAssocCategory<R> extends TQAssocBean<Category,R> {

  public PLong<R> id;
  public PString<R> name;
  public QAssocArticle<R> articles;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs @SuppressWarnings("varargs")
  public final R fetch(TQProperty<QCategory>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs @SuppressWarnings("varargs")
  public final R fetchQuery(TQProperty<QCategory>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Eagerly fetch this association using L2 cache.
   */
  @SafeVarargs @SuppressWarnings("varargs")
  public final R fetchCache(TQProperty<QCategory>... properties) {
    return fetchCacheProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs @SuppressWarnings("varargs")
  public final R fetchLazy(TQProperty<QCategory>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocCategory(String name, R root) {
    super(name, root);
  }

  public QAssocCategory(String name, R root, String prefix) {
    super(name, root, prefix);
  }
}
