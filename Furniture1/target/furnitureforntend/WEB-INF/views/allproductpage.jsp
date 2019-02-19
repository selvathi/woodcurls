<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.view-group {
    display: -ms-flexbox;
    display: flex;
    -ms-flex-direction: row;
    flex-direction: row;
    padding-left: 0;
    margin-bottom: 0;
}
.thumbnail
{
    margin-bottom: 30px;
    padding: 0px;
    -webkit-border-radius: 0px;
    -moz-border-radius: 0px;
    border-radius: 0px;
}

.item.list-group-item
{
    float: none;
    width: 100%;
    background-color: #fff;
    margin-bottom: 30px;
    -ms-flex: 0 0 100%;
    flex: 0 0 100%;
    max-width: 100%;
    padding: 0 1rem;
    border: 0;
}
.item.list-group-item .img-event {
    float: left;
    width: 30%;
}

.item.list-group-item .list-group-image
{
    margin-right: 10px;
}
.item.list-group-item .thumbnail
{
    margin-bottom: 0px;
    display: inline-block;
}
.item.list-group-item .caption
{
    float: left;
    width: 70%;
    margin: 0;
}

.item.list-group-item:before, .item.list-group-item:after
{
    display: table;
    content: " ";
}

.item.list-group-item:after
{
    clear: both;
}
</style>
<script>
$(document).ready(function() {
            $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
            $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
        });
</script>
<div class="container">
    <div class="row">
        <div class="col-lg-12 my-3">
            <div class="pull-right">
                <div class="btn-group">
                    <button class="btn btn-info" id="list">
                        List View
                    </button>
                    <button class="btn btn-danger" id="grid">
                        Grid View
                    </button>
                </div>
            </div>
        </div>
    </div> 
    <div id="products" class="row view-group">
                <div class="item col-xs-4 col-lg-4">
                    <div class="thumbnail card">
                        <div class="img-event">
                            <img class="group list-group-image img-fluid" src="https://ippolitosfurniture.com/wp-content/uploads/2018/06/MRPRW6200-product-400x250.jpg" alt="" />
                        </div>
                        <div class="caption card-body">
                            <h4 class="group card-title inner list-group-item-heading">
                                Dining Table</h4>
                            <p class="group inner list-group-item-text">
                               Innovation and convenience is personified in the Mariposa collection.  
                                Tables that can be used for small dining spaces can also be expanded to accommodate as many as twelve.</p>
                            <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <p class="lead">
                                        $21.000</p>
                                </div>
                                <div class="col-xs-12 col-md-6">
                                    <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item col-xs-4 col-lg-4">
                    <div class="thumbnail card">
                        <div class="img-event">
                            <img class="group list-group-image img-fluid" src="https://i.pinimg.com/originals/39/28/1b/39281b6ba021341a7337cd21ecc39535.jpg" alt="" />
                        </div>
                        <div class="caption card-body">
                            <h4 class="group card-title inner list-group-item-heading">
								Modular fabric Sofa</h4>
                            <p class="group inner list-group-item-text">
                                It is a modular system of upholstered furniture that offers infinite configurations thanks to the different modules in the collection: armchair, corner element, pouf, dormeuse,etc.</p>
                            <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <p class="lead">
                                        $21.000</p>
                                </div>
                                <div class="col-xs-12 col-md-6">
                                    <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item col-xs-4 col-lg-4">
                    <div class="thumbnail card">
                        <div class="img-event">
                            <img class="group list-group-image img-fluid" src="http://www.designasialk.com/images/pro-1.jpg" alt="" />
                        </div>
                        <div class="caption card-body">
                            <h4 class="group card-title inner list-group-item-heading">
                                Office shelving</h4>
                            <p class="group inner list-group-item-text">
                                 Modular office shelving are quite useful because they fit in whatever space.  Short office shelving used as open sideboards can furnish management offices with style and elegance. 
                                 </p>
                            <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <p class="lead">
                                        $21.000</p>
                                </div>
                                <div class="col-xs-12 col-md-6">
                                    <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item col-xs-4 col-lg-4">
                    <div class="thumbnail card">
                        <div class="img-event">
                            <img class="group list-group-image img-fluid" src="https://www.cirey.net/images/bed-7.jpg" alt="" />
                        </div>
                        <div class="caption card-body">
                            <h4 class="group card-title inner list-group-item-heading">
                                Bedroom</h4>
                            <p class="group inner list-group-item-text">
                                Resting on a comfortable bed lets our body regenerate from stress accumulated during the day and it allows to prepare it for the physical and mental strain of the following day                         <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <p class="lead">
                                        $21.000</p>
                                </div>
                                <div class="col-xs-12 col-md-6">
                                    <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item col-xs-4 col-lg-4">
                    <div class="thumbnail card">
                        <div class="img-event">
                            <img class="group list-group-image img-fluid" src="https://www.kimball.com/getmedia/a6dcc965-5448-4f78-a86a-d854684f7493/Gallery_BloomTables_5.aspx/?maxsidesize=400" alt="" />
                        </div>
                        <div class="caption card-body">
                            <h4 class="group card-title inner list-group-item-heading">
                                 TV cabinets</h4>
                            <p class="group inner list-group-item-text">
                                             Everybody has a TV at home. Where to put it sometimes is a problem both from a functional and aesthetical point of view.
                                             The market offers a great variety of TV cabinets.          <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <p class="lead">
                                        $21.000</p>
                                </div>
                                <div class="col-xs-12 col-md-6">
                                    <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item col-xs-4 col-lg-4">
                    <div class="thumbnail card">
                        <div class="img-event">
                            <img class="group list-group-image img-fluid" src="https://b451c108ef7ce3b912eb-75c7695d67180639ae25fac6b37d4ead.ssl.cf3.rackcdn.com/onlinereality/uploads/prod_img/2_24567_s_v1.jpg" alt="" />
                        </div>
                        <div class="caption card-body">
                            <h4 class="group card-title inner list-group-item-heading">
                               Office workstations</h4>
                            <p class="group inner list-group-item-text">
                               Optimizing available space is fundamental in operative areas of the office.
                                The multiple office workstations instead are perfect for open space areas where teamworking is essential. </p>
                            <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <p class="lead">
                                        $21.000</p>
                                </div>
                                <div class="col-xs-12 col-md-6">
                                    <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
</div>